package com.tstcore.easybank.configs;

import com.tstcore.easybank.entities.Customer;
import com.tstcore.easybank.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EazyBankUsernamePwdAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private CustomerRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // 1. Get the username
        String username = authentication.getName();
        // 2. Get the password
        String pwd = authentication.getCredentials().toString();
        // 3. Getting the list of customer users
        List<Customer> customers = repository.findByEmail(username);
        // 4. Check whether the customer list is empty?
        if (!customers.isEmpty()) {
            Customer customer = customers.get(0);
            // 5. check for matching passwords using the passwordEncoder
            if (passwordEncoder.matches(pwd, customers.get(0).getPwd())) {
                List<GrantedAuthority> authorities = new ArrayList<>();
                authorities.add(new SimpleGrantedAuthority(customers.get(0).getRole()));
                return new UsernamePasswordAuthenticationToken(username, pwd, authorities);
            } else {
                throw new BadCredentialsException("Invalid password");
            }
        } else {
            throw new BadCredentialsException("No user registered with these details!");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
