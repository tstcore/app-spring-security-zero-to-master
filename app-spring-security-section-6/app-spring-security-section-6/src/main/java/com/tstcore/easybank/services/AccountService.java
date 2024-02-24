package com.tstcore.easybank.services;

import com.tstcore.easybank.entities.Accounts;

import java.util.Optional;

public interface AccountService {
    Accounts findByCustomerId(int customerId);
}
