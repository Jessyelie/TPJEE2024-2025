package com.isi.dev.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers("/addUser") // Désactive CSRF pour /addUser
                )
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/login", "/home", "/css/**", "/js/**", "/html/**","/addUser").permitAll()
                        .anyRequest().authenticated()
                )
                .oauth2Login(oauth2 -> oauth2
                        .loginPage("/login")
                        .defaultSuccessUrl("/home", true) // Redirige vers /home après connexion
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/") // Redirige après déconnexion
                );
        return http.build();
    }
}
