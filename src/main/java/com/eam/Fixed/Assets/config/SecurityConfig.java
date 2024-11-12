package com.eam.Fixed.Assets.config;

import com.eam.Fixed.Assets.security.CustomAuthSuccessHandler;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.SecurityFilterChain;
import java.lang.String;

import java.io.IOException;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {
    @Autowired
    private CustomAuthSuccessHandler customAuthSuccessHandler;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/user","/logoutapp").permitAll()
                        .requestMatchers("/api/**").authenticated()
                        .anyRequest().authenticated()
                )
                .oauth2Login(oauth2 -> oauth2
                        .successHandler(customAuthSuccessHandler)
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/user")
                        .invalidateHttpSession(true)
                        .clearAuthentication(true)
                        .deleteCookies("JSESSIONID")
                        .addLogoutHandler((request, response, authentication) -> {
                            OAuth2User oauth2User = (OAuth2User) authentication.getPrincipal();
                            String token = (String) oauth2User.getAttributes().get("id_token");
                            System.out.println(token);
                            String logoutUrl = "https://login.microsoftonline.com/b7043ae5-9a0c-436d-91f0-1fcb69122965/oauth2/v2.0/logout?id_token_hint="+token;
                            try {
                                response.sendRedirect("http://localhost:7005/logoutapp");
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        })
                );
        return http.build();
    }
}