/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petshop.config;

import com.petshop.security.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {

        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(customUserDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder);

        return authProvider;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
        .csrf(csrf -> csrf.disable())

        .authenticationProvider(authenticationProvider())

        .authorizeHttpRequests(auth -> auth

            .requestMatchers("/css/**","/js/**","/images/**").permitAll()

            .requestMatchers("/login","/register").permitAll()

            .requestMatchers("/admin/**").hasRole("ADMIN")

            .requestMatchers("/shop/**").hasRole("SHOP")

            .requestMatchers("/cart/**","/orders/**","/profile/**")
            .hasRole("CUSTOMER")

            .anyRequest().permitAll()
        )

        .formLogin(login -> login
                .loginPage("/login")
                .loginProcessingUrl("/do-login")
                .defaultSuccessUrl("/")
                .permitAll()
        )

        .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login")
        );

        return http.build();
    }
}