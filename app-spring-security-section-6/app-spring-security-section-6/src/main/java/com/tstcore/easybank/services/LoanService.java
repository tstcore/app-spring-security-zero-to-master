package com.tstcore.easybank.services;

import com.tstcore.easybank.entities.Loans;

import java.util.List;

public interface LoanService {
    List<Loans> findAllLoans(int customerId);
}
