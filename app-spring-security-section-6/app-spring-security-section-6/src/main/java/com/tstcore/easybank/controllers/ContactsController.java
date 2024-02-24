package com.tstcore.easybank.controllers;

import com.tstcore.easybank.entities.Contact;
import com.tstcore.easybank.services.ContactService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactsController {

    private final ContactService service;

    public ContactsController(ContactService service) {
        this.service = service;
    }

    /**
     *
     * @return
     */
    @GetMapping(value = "/contacts")
    public String getContactsEnquiry() {
        return "<h2>Here are the contacts details from the DB</h2>";
    }

    /**
     *
     * @param contact
     * @return
     */
    @PostMapping(value = "/contacts")
    public ResponseEntity<Contact> handleSaveContactInquiryDetails(@RequestBody Contact contact) {
        return new ResponseEntity<>(service.saveContact(contact),HttpStatus.OK);
    }
}
