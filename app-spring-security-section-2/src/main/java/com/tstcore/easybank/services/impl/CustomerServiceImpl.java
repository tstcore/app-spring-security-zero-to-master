package com.tstcore.easybank.services.impl;

import com.tstcore.easybank.exceptions.UserNotCreatedException;
import com.tstcore.easybank.models.Customer;
import com.tstcore.easybank.repositories.CustomerRepository;
import com.tstcore.easybank.services.CustomerService;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public String createCustomer(Customer customer) {
        try {
            var savedCustomer = repository.save(customer);
            if (savedCustomer.getId() > 0) {
                return "Given Customer details are successfully registered";
            }
        } catch (Exception e) {
            throw new UserNotCreatedException("An exception occurred due to " + e.getMessage());
        }
        return null;
    }
}
