package com.udemy.microservices.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Without this class what happens to this application is that whenever we open our browser to run a uri of this api,
 * a web page would appear to use the credentials for login.
 *
 * The objective of this is to:
 * 1) All requests should be authenticated
 * 2) If a request is not authenticated, a web page is shown
 * 3) CSRF -> POST, PUT
 */
@Configuration
public class SpringSecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // 1) All requests should be authenticated
        http.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated()
        );

        // 2) If a request is not authenticated, a web page is shown
        http.httpBasic(Customizer.withDefaults());

        // 3) CSRF -> POST, PUT
        http.csrf().disable();

        return http.build();
    }
}
