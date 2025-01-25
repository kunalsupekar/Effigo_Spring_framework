package com.example.MyFirstWebApplication.SpringSecurity;


import java.awt.im.InputContext;
import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SpringSecurityConfiguration {

//	InMemoryUserDetailsManager
//	inMemoryUserDetailsManager(UserDetails...users )
	
	@Bean
	public InMemoryUserDetailsManager createUserDetailsManager() {
	Function<String, String> passwordEncoder=
			Input -> passwordEncoder().encode(Input);
	UserDetails userDetails=	User.builder()
								.passwordEncoder(passwordEncoder)
								.username("kunal")
								.password("shaku")
								.roles("USER","ADMIN")
								.build();
								
	 return new InMemoryUserDetailsManager(userDetails);
	}
	
	@Bean
	public PasswordEncoder 	passwordEncoder() {
		return new BCryptPasswordEncoder();
		
	}
	
}
