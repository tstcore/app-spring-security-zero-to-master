package com.tstcore.easybank.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardsController {

    @GetMapping(value = "/myCards")
    public String getCardDetails() {
        return "<h2>Here are the cards details from the DB</h2>";
    }
}
