package org.example.tacocloud.configs;

import org.example.tacocloud.domains.User;
import org.example.tacocloud.repositories.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepo) {
        return username -> {
            User user = userRepo.findByUsername(username);
            if (user != null) return user;
            throw new UsernameNotFoundException("User '" + username + "' not found");
        };
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests -> {
                    authorizeRequests
                            .requestMatchers("/design", "/orders").hasRole("USER")
                            .requestMatchers("/", "/**").permitAll();
                })
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/design")
                )
                .logout((logout) -> logout.logoutUrl("/logout")
                        .logoutSuccessUrl("/login"));


        return http.build();
    }

}
