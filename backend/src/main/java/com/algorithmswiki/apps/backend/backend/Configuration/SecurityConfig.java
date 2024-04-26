package com.algorithmswiki.apps.backend.backend.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .anyRequest().permitAll() // Permit all requests
                .and()
            .csrf().disable() // Disable CSRF protection (optional, depending on your needs)
            .formLogin().disable() // Disable form login
            .httpBasic().disable(); // Disable HTTP Basic authentication

        return http.build();
    }
}
