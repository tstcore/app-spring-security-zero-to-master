package com.tstcore.easybank.services.impl;

import com.tstcore.easybank.entities.Customer;
import com.tstcore.easybank.exceptions.UserNotCreatedException;
import com.tstcore.easybank.repositories.CustomerRepository;
import com.tstcore.easybank.services.LoginService;
import com.tstcore.easybank.utils.DateUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {
    private final CustomerRepository repository;
    private final PasswordEncoder encoder;

    public LoginServiceImpl(CustomerRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }
    /**
     *
     * @param customer
     * @return
     */
    @Override
    public String registerUser(Customer customer) {
        //-- 1. Encrypt/Hash the password
        String hashPwd = hashPassword(customer.getPwd());
        //-- 2. Set the hashed password amd created date for the Customer object
        customer.setPwd(hashPwd);
        customer.setCreateDt(DateUtil.getDateFormat());
        //-- 3. Save the Customer object with a newly hashed password
        var savedCustomer = repository.save(customer);
        //-- 4. Check whether
         if(savedCustomer.getId() > 0) {
             return "Given user details are successfully registered.";
         } else {
             throw new UserNotCreatedException();
         }
    }
    /**
     *
     * @param email
     * @return
     */
    @Override
    public Customer findByEmail(String email) {
        List<Customer> customers = repository.findByEmail(email);
        return !customers.isEmpty() ? customers.get(0) : null;
    }

    /**
     *
     * @param password
     * @return
     */
    private String hashPassword(String password){
        return encoder.encode(password);
    }
}
