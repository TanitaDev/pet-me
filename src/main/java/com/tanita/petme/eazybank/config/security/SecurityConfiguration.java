package com.tanita.petme.eazybank.config.security;

import com.tanita.petme.eazybank.exceptionhandler.CustomAccessDeniedHandler;
import com.tanita.petme.eazybank.exceptionhandler.CustomBasicAuthenticationEntryPoint;
import com.tanita.petme.filter.AutheticationLogginAtFilter;
import com.tanita.petme.filter.RequestValidationBeforeFilter;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.password.CompromisedPasswordChecker;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.password.HaveIBeenPwnedRestApiPasswordChecker;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.Collections;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@Profile("!prod")
public class SecurityConfiguration {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.cors(corsConfig -> corsConfig.configurationSource(new CorsConfigurationSource() {
            @Override
            public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                CorsConfiguration config = new CorsConfiguration();
                config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
                config.setAllowedMethods(Collections.singletonList("*"));
                config.setAllowCredentials(true);
                config.setAllowedHeaders(Collections.singletonList("*"));
                config.setMaxAge(3600L);
                return null;
            }
        }));
        http
                .csrf(AbstractHttpConfigurer::disable)
                .addFilterBefore(new RequestValidationBeforeFilter(), BasicAuthenticationFilter.class)
                .addFilterAt(new AutheticationLogginAtFilter(), WebAsyncManagerIntegrationFilter.class)
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/api/bankme/account").hasRole("USER")
                        .requestMatchers("/api/bankme/cards").hasRole("USER")
                        .requestMatchers("/api/bankme/loans").hasRole("USER")
                        .requestMatchers("/api/bankme/balance").hasAnyRole("USER", "ADMIN")
                        .requestMatchers("/api/bankme/user").authenticated()
                        .requestMatchers("/api/bankme/contact", "/api/bankme/register").permitAll());
        http.formLogin(withDefaults());
        http.httpBasic(hbc ->
                hbc.authenticationEntryPoint(new CustomBasicAuthenticationEntryPoint()));
        http.exceptionHandling(ehc ->
                ehc.accessDeniedHandler(new CustomAccessDeniedHandler()).accessDeniedPage("/denied"));
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public CompromisedPasswordChecker compromisedPasswordChecker() {
        return new HaveIBeenPwnedRestApiPasswordChecker();
    }

}
