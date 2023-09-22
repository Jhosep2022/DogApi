package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class GlobalSecurityConfiguration {
    private final KeycloakJwtTokenConverter keycloakJwtTokenConverter;

    public GlobalSecurityConfiguration (TokenConverterProperties properties) {
        JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter
                = new JwtGrantedAuthoritiesConverter();
        this.keycloakJwtTokenConverter
                = new KeycloakJwtTokenConverter (
                jwtGrantedAuthoritiesConverter,
                properties);
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests( (authorizeHttpRequests) -> {
            authorizeHttpRequests
                    .requestMatchers(HttpMethod.GET,"/api/dogs/fetch").hasRole("USER")
                    .requestMatchers(HttpMethod.GET,"/api/dogs/list").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.PUT,"/api/dogs/list/update").hasRole("ADMIN")
                    .requestMatchers (HttpMethod.OPTIONS, "/**").permitAll()
                    .anyRequest().denyAll();
        });
        http.oauth2ResourceServer ((oauth2) -> {
            oauth2.jwt( (jwt) -> jwt.jwtAuthenticationConverter (keycloakJwtTokenConverter));
        });
        http.sessionManagement((session) -> session.sessionCreationPolicy (SessionCreationPolicy.STATELESS));
        return http.build();
    }
}

