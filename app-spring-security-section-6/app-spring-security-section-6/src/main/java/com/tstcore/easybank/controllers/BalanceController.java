package com.tstcore.easybank.controllers;

import com.tstcore.easybank.entities.AccountTransactions;
import com.tstcore.easybank.services.AccountTransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BalanceController {

    private final AccountTransactionService service;

    public BalanceController(AccountTransactionService service) {
        this.service = service;
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/myBalance")
    public ResponseEntity<List<AccountTransactions>> getBalanceDetails(@RequestParam int id) {
        return new ResponseEntity<>(service.findByCustomerId(id), HttpStatus.OK);
    }
}
