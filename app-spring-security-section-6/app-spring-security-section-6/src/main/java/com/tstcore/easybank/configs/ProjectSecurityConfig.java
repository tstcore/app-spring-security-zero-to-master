package com.tstcore.easybank.configs;

import com.tstcore.easybank.filters.CsrfCookiesFilter;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.security.web.server.csrf.CookieServerCsrfTokenRepository;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.Collections;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        //-- CsrfTokenRequestAttributeHandler for generating a CSRF token to be available as an attribute
        CsrfTokenRequestAttributeHandler requestHandler = new CsrfTokenRequestAttributeHandler();
        requestHandler.setCsrfRequestAttributeName("_csrf");
        //--
        //--
        http    //-- creating the sessionID using the session management below
                .securityContext(context -> context.requireExplicitSave(false))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS))
                //-- CORS: Cross Origin Resource Sharing global settings
                .cors(corsCustomizer -> corsCustomizer
                        .configurationSource(new CorsConfigurationSource() {
                            @Override
                            public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                                CorsConfiguration config = new CorsConfiguration();
                                config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
                                config.setAllowedMethods(Collections.singletonList("*"));
                                config.setAllowCredentials(true);
                                config.setAllowedHeaders(Collections.singletonList("*"));
                                config.setMaxAge(3600L);
                                return config;
                            }
                        }))
                //-- CSRF: Cross-Site Resource Forgery global setting for non-secured POST API's
                //-- For API's that do not pass the BodyRequest
                .csrf(  //-- adding the CSRF Token request handler
                        (csrf) -> csrf.csrfTokenRequestHandler(requestHandler)
                        //-- Adding API's that needs no CSRF configuration
                        .ignoringRequestMatchers("/contacts","/register")
                        //--
                        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
                        //--
                        .addFilterAfter(new CsrfCookiesFilter(), BasicAuthenticationFilter.class)
                //-- resources that require authorization and authentication
                .authorizeHttpRequests(
                        //-- request resources that require authorization and authentication
                        (requests) -> requests.requestMatchers("/myAccount"
                                        , "/myBalance"
                                        , "/myCards"
                                        , "/myLoans"
                                        , "/user")
                                .authenticated()
                                //-- request resources that require no authorization
                                .requestMatchers("/contacts"
                                        , "/notices"
                                        , "/register"
                                        , "/swagger-ui/**"
                                        , "/api-docs/**")
                                .permitAll());
        http.formLogin(Customizer.withDefaults());
        http.httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
