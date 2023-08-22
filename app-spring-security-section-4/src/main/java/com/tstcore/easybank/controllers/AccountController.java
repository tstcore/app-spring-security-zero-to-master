package com.tstcore.easybank.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @GetMapping(value = "/myAccount")
    public String handleWelcome() {
        return "<h2>Here are the account details from the database</h2>";
    }
}
