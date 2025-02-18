package com.example.SpringSecurity.basic;

import static org.springframework.security.config.Customizer.withDefaults;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class BasicAuthSecurityConfiguration {

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
        
        http.headers(headers -> headers.frameOptions(frame -> frame.sameOrigin())); // ✅ Correct syntax

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
}
