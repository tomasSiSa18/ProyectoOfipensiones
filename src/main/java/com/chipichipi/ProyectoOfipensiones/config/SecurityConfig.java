package com.chipichipi.ProyectoOfipensiones.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true) // Usa @EnableMethodSecurity en lugar de @EnableGlobalMethodSecurity
public class SecurityConfig {

    @Value("${okta.oauth2.issuer}")
    private String issuer;
    @Value("${okta.oauth2.client-id}")
    private String clientId;

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/").permitAll()  // Permite acceso a la raíz
                .anyRequest().authenticated()  // Requiere autenticación para el resto
            )
            .oauth2Login(oauth2 -> oauth2
                .defaultSuccessUrl("/home", true)  // Redirige a /ofipensiones/home después del login
            )
            .logout(logout -> logout
                .logoutUrl("/logout")  // URL de logout
                .logoutSuccessUrl("/")  // Redirige a la raíz después del logout
                .addLogoutHandler(logoutHandler()));

        return http.build();
    }

    private LogoutHandler logoutHandler() {
        return (request, response, authentication) -> {
            try {
                String baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
                response.sendRedirect(issuer + "v2/logout?client_id=" + clientId + "&returnTo=" + baseUrl);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
    }
}
