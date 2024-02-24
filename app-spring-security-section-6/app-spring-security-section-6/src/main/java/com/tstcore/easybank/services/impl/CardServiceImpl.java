package com.tstcore.easybank.services.impl;

import com.tstcore.easybank.entities.Accounts;
import com.tstcore.easybank.entities.Cards;
import com.tstcore.easybank.exceptions.ResourceNotFoundException;
import com.tstcore.easybank.repositories.AccountsRepository;
import com.tstcore.easybank.repositories.CardsRepository;
import com.tstcore.easybank.services.AccountService;
import com.tstcore.easybank.services.CardsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServiceImpl implements CardsService {
    private final CardsRepository repository;

    public CardServiceImpl(CardsRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Cards> findByCustomerId(int customerId) {
        return repository.findByCustomerId(customerId);
    }
}
