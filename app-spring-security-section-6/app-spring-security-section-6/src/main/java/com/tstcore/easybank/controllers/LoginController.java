package com.tstcore.easybank.controllers;

import com.tstcore.easybank.entities.Customer;
import com.tstcore.easybank.services.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private final LoginService service;

    public LoginController(LoginService service) {
        this.service = service;
    }

    /**
     * @param customer
     * @return
     */
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Customer customer) {
        return new ResponseEntity<>(service.registerUser(customer), HttpStatus.CREATED);
    }
    /**
     *
     * @param authentication
     * @return
     */
    @RequestMapping(value = "/user")
    public ResponseEntity<Customer> getUserDetailsAfterLogin(Authentication authentication) {
        return new ResponseEntity<>(service.findByEmail(authentication.getName()),HttpStatus.FOUND);
    }
}
