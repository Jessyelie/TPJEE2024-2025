package com.isi.dev.start.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.List;

//@Configuration
//public class SecurityConfig {
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;

    @Configuration
    public class SecurityConfig {

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            http
                    .csrf(csrf -> csrf.disable())  // Désactiver CSRF
                    .authorizeHttpRequests(auth -> auth
                            .anyRequest().permitAll()  // Autoriser toutes les requêtes sans restriction
                    );
                    //.formLogin(login -> login.disable())  // Désactiver la redirection vers /login
                    //.httpBasic(basic -> basic.disable()); // Désactiver l'authentification basique

            return http.build();
        }
    }

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .cors(cors -> cors.disable()) // Désactiver CORS géré par Spring Security (on utilise un filtre séparé)
//                .csrf(csrf -> csrf.disable()) // Désactiver CSRF pour les API REST
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/api/users/login", "/api/users/register").permitAll() // Autoriser les routes de login/register
//                        .anyRequest().authenticated()
//                )
//                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .formLogin(login -> login.disable()) // Désactiver la redirection automatique de Spring Security
//                .httpBasic(basic -> basic.disable()); // Désactiver l'authentification basique
//
//        return http.build();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
//        return authConfig.getAuthenticationManager();
//    }
//
//    // ✅ Ajout d'un filtre CORS séparé pour éviter les blocages 403
//    @Bean
//    public CorsFilter corsFilter() {
//        CorsConfiguration config = new CorsConfiguration();
//        config.setAllowCredentials(true);
//        config.setAllowedOrigins(List.of("http://localhost:5173")); // Remplace par l'URL de ton frontend
//        config.setAllowedHeaders(List.of("Authorization", "Content-Type"));
//        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
//
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", config);
//
//        return new CorsFilter(source);
//    }
//}
