package com.tstcore.easybank.services.impl;

import com.tstcore.easybank.entities.Contact;
import com.tstcore.easybank.repositories.ContactRepository;
import com.tstcore.easybank.services.ContactService;
import com.tstcore.easybank.utils.RequestNumUtil;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class ContactServiceImpl implements ContactService {
    private final ContactRepository repository;

    public ContactServiceImpl(ContactRepository repository) {
        this.repository = repository;
    }

    @Override
    public Contact saveContact(Contact contact) {
        contact.setContactId(RequestNumUtil.getServiceRequestNumber());
        contact.setCreateDt(new Date(System.currentTimeMillis()));
        return repository.save(contact);
    }
}
