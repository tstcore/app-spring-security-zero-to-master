package com.tstcore.easybank.controllers;

import com.tstcore.easybank.entities.Loans;
import com.tstcore.easybank.services.LoanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoansController {
    private final LoanService service;

    public LoansController(LoanService service) {
        this.service = service;
    }
    /**
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/myLoans")
    public ResponseEntity<List<Loans>> getLoanDetails(@RequestParam int id) {
        return new ResponseEntity<>(service.findAllLoans(id), HttpStatus.OK);
    }
}
