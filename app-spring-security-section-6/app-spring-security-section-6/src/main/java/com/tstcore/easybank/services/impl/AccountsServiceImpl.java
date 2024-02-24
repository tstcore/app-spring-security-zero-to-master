package com.tstcore.easybank.services.impl;

import com.tstcore.easybank.entities.Accounts;
import com.tstcore.easybank.exceptions.ResourceNotFoundException;
import com.tstcore.easybank.repositories.AccountsRepository;
import com.tstcore.easybank.services.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountsServiceImpl implements AccountService {
    private final AccountsRepository repository;

    public AccountsServiceImpl(AccountsRepository repository) {
        this.repository = repository;
    }

    @Override
    public Accounts findByCustomerId(int customerId) {
        return repository.findByCustomerId(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "customerId", customerId));
    }
}
