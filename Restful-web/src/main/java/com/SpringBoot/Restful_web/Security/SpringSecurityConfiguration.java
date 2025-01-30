package com.SpringBoot.Restful_web.Security;

import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .anyRequest().authenticated() // Require authentication for all requests
            )
            .httpBasic(withDefaults()); // Enable HTTP Basic Authentication
            //.csrf(csrf -> csrf.disable()); // New way to disable CSRF

        http.csrf(csrf -> csrf.disable());
        return http.build();
    }
}
