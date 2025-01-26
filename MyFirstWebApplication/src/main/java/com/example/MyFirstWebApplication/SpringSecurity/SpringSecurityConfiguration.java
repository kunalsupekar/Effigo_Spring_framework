package com.example.MyFirstWebApplication.SpringSecurity;

import static org.springframework.security.config.Customizer.withDefaults;

import java.awt.im.InputContext;
import java.sql.Struct;
import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {

//	InMemoryUserDetailsManager
//	inMemoryUserDetailsManager(UserDetails...users )
	
	@Bean
	public InMemoryUserDetailsManager createUserDetailsManager() {
		
		
	UserDetails userDetails1 = createNewUser("kunal", "shaku");
	UserDetails userDetails2 = createNewUser("123", "123");
						
	 return new InMemoryUserDetailsManager(userDetails1,userDetails2);
	}

private UserDetails createNewUser(String username, String password) {
	Function<String, String> passwordEncoder=
			Input -> passwordEncoder().encode(Input);
	UserDetails userDetails=	User.builder()
								.passwordEncoder(passwordEncoder)
								.username(username)
								.password(password)
								.roles("USER","ADMIN")
								.build();
	return userDetails;
}
	
	@Bean
	public PasswordEncoder 	passwordEncoder() {
		return new BCryptPasswordEncoder();
		
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests(
				auth -> auth.anyRequest().authenticated());
		http.formLogin(withDefaults());
		
		http.csrf().disable();
		http.headers().frameOptions().disable();
		
		return http.build();
	}
}
