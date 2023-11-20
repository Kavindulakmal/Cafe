package com.bill.ElecBill.service;

import com.bill.ElecBill.model.Customer;
import com.bill.ElecBill.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer findById(Long customerId) {
        return customerRepository.findById(customerId).orElse(null);
    }
}
