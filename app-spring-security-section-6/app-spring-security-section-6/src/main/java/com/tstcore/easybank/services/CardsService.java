package com.tstcore.easybank.services;

import com.tstcore.easybank.entities.Cards;

import java.util.List;

public interface CardsService {
    List<Cards> findByCustomerId(int id);

}
