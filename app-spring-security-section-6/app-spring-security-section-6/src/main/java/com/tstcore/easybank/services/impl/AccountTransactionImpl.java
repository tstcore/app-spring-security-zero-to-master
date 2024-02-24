package com.tstcore.easybank.services.impl;

import com.tstcore.easybank.entities.AccountTransactions;
import com.tstcore.easybank.repositories.AccountTransactionRepository;
import com.tstcore.easybank.services.AccountTransactionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountTransactionImpl implements AccountTransactionService {
    private final AccountTransactionRepository repository;

    public AccountTransactionImpl(AccountTransactionRepository repository) {
        this.repository = repository;
    }
    /**
     *
     * @param id
     * @return
     */
    @Override
    public List<AccountTransactions> findByCustomerId(int id) {
        return repository.findByCustomerIdOrderByTransactionDtDesc(id);
    }
}
