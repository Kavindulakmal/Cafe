package com.bill.ElecBill.controller;

import com.bill.ElecBill.model.Bill;
import com.bill.ElecBill.model.Customer;
import com.bill.ElecBill.service.BillingService;
import com.bill.ElecBill.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/billing")
public class BillingController {

    @Autowired
    private BillingService billingService;
    private CustomerService customerService;


    //calculate bill
    @PostMapping("/calculate")
    public ResponseEntity<Bill> calculateBill(@RequestBody Customer customer){
        Bill bill = BillingService.calculateBill(customer);
        return new ResponseEntity<>(bill, HttpStatus.OK);
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<Bill> getBill(@PathVariable Long customerId) {
        // Assume you have a service method to retrieve customer information by ID from the database
        Customer customer = customerService.findById(customerId); // Replace 'customerService' with your actual service name

        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Bill bill = billingService.calculateBill(customer);
        return new ResponseEntity<>(bill, HttpStatus.OK);
    }



}
