package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebMvc
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorizeRequests -> { 
                authorizeRequests 
                .requestMatchers("/", "/catalogo", "/cart/**").permitAll() 
                .requestMatchers("/api/products").permitAll()
                .requestMatchers("/products/**", "/admin").hasRole("ADMIN") 
                .anyRequest().authenticated(); 
            })
            .formLogin(formLogin -> formLogin 
                .loginPage("/login")
                .defaultSuccessUrl("/catalogo") 
                .permitAll()
            )
            .logout(logout -> logout 
                .logoutUrl("/logout") 
                .logoutSuccessUrl("/login?logout")
            )
            .exceptionHandling(exceptionHandling -> exceptionHandling
                .accessDeniedPage("/access-denied")
            );

        return http.build();
    }
}
