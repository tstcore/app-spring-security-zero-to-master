package com.tstcore.easybank.services;

import com.tstcore.easybank.entities.Customer;

public interface LoginService {
    String registerUser(Customer customer);
    Customer findByEmail(String email);
}
