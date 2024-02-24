package com.tstcore.easybank.repositories;

import com.tstcore.easybank.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
