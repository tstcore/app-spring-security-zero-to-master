package com.tstcore.appspringsecuritybasic.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping(value = "/welcome")
    public String handleWelcome() {
        return "<h2>Welcome to a Spring Application with Security credentials.</h2>";
    }
}
