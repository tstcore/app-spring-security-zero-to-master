package com.tstcore.easybank.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.csrf((csrf)-> csrf.disable())
                .authorizeHttpRequests((requests) -> requests.requestMatchers("/myAccount",
                        "/myBalance",
                        "/myCards",
                        "/myLoans")
                .authenticated()
                .requestMatchers("/contacts","/notices","/register","/swagger-ui/**","/api-docs/**").permitAll());
        http.formLogin(Customizer.withDefaults());
        http.httpBasic(Customizer.withDefaults());
        return http.build();
    }

/** @Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    } */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
/**
 * ------------------------------------------------------------------------------------
 */
    /**    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails admin = mapToUserDetails("admin","12345", "admin");
        UserDetails user = mapToUserDetails("user","23456","read");
        return new InMemoryUserDetailsManager(admin,user);
    } */
    /**
     * As part of Approach 2. NoOPPasswordEncoder is not recommended for production usage
     * Use only for non-production
     */
    private UserDetails mapToUserDetails(String username,String password, String role) {
        /** Approach 2 where we use NoOpPasswordEncoder bean while creating the user details */
        return User.withUsername(username)
                .password(password)
                .authorities(role).build();
        /**
         * Approach 1 where we use withDefaultPasswordEncoder() method while creating the user details
         * return User.withDefaultPasswordEncoder()
                .username(username)
                .password(password)
                .authorities(role).build();
     */
    }
}
