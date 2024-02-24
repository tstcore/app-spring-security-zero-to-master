package com.tstcore.easybank.services;

import com.tstcore.easybank.entities.AccountTransactions;

import java.util.List;

public interface AccountTransactionService {
    List<AccountTransactions> findByCustomerId(int id);
}
