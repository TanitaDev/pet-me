package com.tanita.dateme.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

@Configuration
public class SecurityConfiguration {

    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .httpBasic(httpBasic -> httpBasic
                        .realmName("name")
                        .authenticationEntryPoint(new BasicAuthenticationEntryPoint())
                        .authenticationDetailsSource(new WebAuthenticationDetailsSource())
                )
                .build();
    }

}
