package com.tstcore.easybank.repositories;

import com.tstcore.easybank.entities.AccountTransactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountTransactionRepository extends JpaRepository<AccountTransactions, Long> {
    List<AccountTransactions> findByCustomerIdOrderByTransactionDtDesc(int customerId);
}
