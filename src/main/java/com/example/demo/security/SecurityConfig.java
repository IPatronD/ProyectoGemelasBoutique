package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    // BCrypt
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Configuración de seguridad
    @Bean
    public SecurityFilterChain filterChain(
            HttpSecurity http) throws Exception {

        http

                // Desactiva CSRF para Postman
                .csrf(csrf -> csrf.disable())

                // Configuración de permisos
                .authorizeHttpRequests(auth -> auth

                        // SOLO ADMIN
                        .requestMatchers(
                                "/api/usuarios/**")
                        .hasRole("ADMIN")

                        // ADMIN y VENDEDOR
                        .requestMatchers(
                                "/api/ventas/**",
                                "/api/detalle-ventas/**")
                        .hasAnyRole("ADMIN", "VENDEDOR")

                        // Cualquier usuario autenticado
                        .anyRequest()
                        .authenticated())

                .httpBasic(httpBasic -> {});
                
        return http.build();
    }
}
