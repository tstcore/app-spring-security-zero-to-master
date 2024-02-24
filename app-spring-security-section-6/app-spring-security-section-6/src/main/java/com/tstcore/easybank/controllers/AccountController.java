package com.tstcore.easybank.controllers;

import com.tstcore.easybank.entities.Accounts;
import com.tstcore.easybank.services.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    private final AccountService service;

    public AccountController(AccountService service) {
        this.service = service;
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/myAccount")
    public ResponseEntity<Accounts> handleWelcome(@RequestParam int id) {
        return new ResponseEntity<>(service.findByCustomerId(id), HttpStatus.OK);
    }
}
