package com.egg.connections.customer.controllers;

import com.egg.connections.customer.models.Customer;
import com.egg.connections.customer.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public List<Customer> getAll(){
        return customerService.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public Customer create(@RequestBody Customer customer){
        return customerService.create(customer);
    }
}
