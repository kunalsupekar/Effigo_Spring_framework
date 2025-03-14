package com.example.SpringSecurity.jwt;

import static org.springframework.security.config.Customizer.withDefaults;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPublicKey;
import java.util.UUID;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;

//@Configuration
public class JwtSecurityConfiguration2 {

    public enum Roles { // Enum should be PascalCase
        ADMIN, USER
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth
                .anyRequest().authenticated()
        );
        http.sessionManagement(session -> session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        );
        http.httpBasic(withDefaults());
        http.csrf(csrf -> csrf.disable());
        
        http.headers(headers -> headers.frameOptions(frame -> frame.sameOrigin())); //  Correct syntax
        
       // http.oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
        
        http.oauth2ResourceServer((oauth2) -> oauth2.jwt(Customizer.withDefaults()));

        return http.build();
    }

    @Bean
    public DataSource dataSource() {
    	return new EmbeddedDatabaseBuilder()
    				.setType(EmbeddedDatabaseType.H2)
    				.addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION)
    				.build();
    }
    
    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource,BCryptPasswordEncoder bCryptPasswordEncoder) {
        var user = User.withUsername("kunal")
              //  .password("{noop}123") // {noop} for plain text password
                .password("123")
                .passwordEncoder(str->bCryptPasswordEncoder.encode(str))
        		.roles(Roles.USER.name()) // Converts to "USER", automatically prefixed to "ROLE_USER"
                .build();

        var admin = User.withUsername("admin")
                //.password("{noop}123") // {noop} for plain text password
        		  .password("123")
                  .passwordEncoder(str->bCryptPasswordEncoder.encode(str))
        		.roles(Roles.ADMIN.name(),Roles.USER.name()) // Converts to "ADMIN", automatically prefixed to "ROLE_ADMIN"
                .build();
        
        var jdbcUserDetailsManager =new JdbcUserDetailsManager(dataSource);

        jdbcUserDetailsManager.createUser(user);
        jdbcUserDetailsManager.createUser(admin);

       // return new InMemoryUserDetailsManager(user, admin);
        return jdbcUserDetailsManager;
    }
    
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
    	return new BCryptPasswordEncoder();
    }
    
    @Bean
    public KeyPair keyPair() throws NoSuchAlgorithmException {
    	
    	var keyPairGenerator=KeyPairGenerator.getInstance("RSA");
    	keyPairGenerator.initialize(2048);
    	return keyPairGenerator.generateKeyPair();
        }
    
    @Bean
    public RSAKey rsaKey(KeyPair keyPair) {
    	
    return 	new RSAKey
    		.Builder((RSAPublicKey)keyPair.getPublic())
			.privateKey(keyPair.getPrivate())
			.keyID(UUID.randomUUID().toString())
			.build();
    }
    
    
    @Bean
	public JWKSource<SecurityContext> jwkSource(RSAKey rsaKey) {
		var jwkSet = new JWKSet(rsaKey);
		
		return (jwkSelector, context) ->  jwkSelector.select(jwkSet);
		
	}
    
    @Bean
	public JwtDecoder jwtDecoder(RSAKey rsaKey) throws JOSEException {
		return NimbusJwtDecoder
				.withPublicKey(rsaKey.toRSAPublicKey())
				.build();
		
	}
    
    @Bean
	public JwtEncoder jwtEncoder(JWKSource<SecurityContext> jwkSource) {
		return new NimbusJwtEncoder(jwkSource);
	}
}
