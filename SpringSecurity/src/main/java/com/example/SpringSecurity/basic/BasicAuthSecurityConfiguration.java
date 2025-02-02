package com.example.SpringSecurity.basic;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
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
    public UserDetailsService userDetailsService() {
        var user = User.withUsername("kunal")
                .password("{noop}123") // {noop} for plain text password
                .roles(Roles.USER.name()) // Converts to "USER", automatically prefixed to "ROLE_USER"
                .build();

        var admin = User.withUsername("admin")
                .password("{noop}123") // {noop} for plain text password
                .roles(Roles.ADMIN.name()) // Converts to "ADMIN", automatically prefixed to "ROLE_ADMIN"
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }
}
