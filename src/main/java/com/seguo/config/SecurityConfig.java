package com.seguo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/*@Configuration
@EnableWebSecurity*/
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .formLogin(formLogin -> formLogin
                        .loginPage("/login")
                        .loginProcessingUrl("/verify")
                        .failureForwardUrl("/")
                        .usernameParameter("email")
                        .passwordParameter("password")
                )
                .authorizeHttpRequests(authorizationManagerRequestMatcherRegistry -> authorizationManagerRequestMatcherRegistry
                        .requestMatchers("/","/login","/build/**","/vendor/**").permitAll()
                        .requestMatchers("/backend/**").hasAnyAuthority("admin")
                        .anyRequest().authenticated()
                );

        return http.build();
    }
}
