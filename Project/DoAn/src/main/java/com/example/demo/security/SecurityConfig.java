package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails duy = User.builder()
                .username("duy2004@gmail.com")
                .password("{noop}123456")
                .roles("EMPLOYEE")
                .build();
        return new InMemoryUserDetailsManager(duy);
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(configure -> configure
                        .requestMatchers("/css/**").permitAll()
                        .requestMatchers("/forgot-password", "/register").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form.loginPage("/login")
                        .loginProcessingUrl("/authenticate")
                        .permitAll()
                )
                .logout(logout -> logout.permitAll());
        return httpSecurity.build();
    }
}
