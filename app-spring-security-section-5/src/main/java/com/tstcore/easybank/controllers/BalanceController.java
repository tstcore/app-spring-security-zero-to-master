package com.tstcore.easybank.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BalanceController {
    @GetMapping(value = "/myBalance")
    public String getBalanceDetails() {
        return "<h2>Here are the balance details from the database</h2>";
    }
}
