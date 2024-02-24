package com.tstcore.easybank.services.impl;

import com.tstcore.easybank.entities.Loans;
import com.tstcore.easybank.repositories.LoansRepository;
import com.tstcore.easybank.services.LoanService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanServiceImpl implements LoanService {
    private final LoansRepository repository;

    public LoanServiceImpl(LoansRepository repository) {
        this.repository = repository;
    }
    /**
     *
     * @param customerId
     * @return
     */
    @Override
    public List<Loans> findAllLoans(int customerId) {
        return repository.findByCustomerIdOrderByStartDtDesc(customerId);
    }
}
