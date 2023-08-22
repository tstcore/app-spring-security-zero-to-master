package com.tstcore.easybank.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactsController {

    @GetMapping(value = "/contacts")
    public String getContactsEnquiry() {
        return "<h2>Here are the contacts details from the DB</h2>";
    }
}
