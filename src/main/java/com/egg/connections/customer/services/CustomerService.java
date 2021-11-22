package com.egg.connections.customer.services;

import com.egg.connections.customer.models.Customer;
import com.egg.connections.customer.repo.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    public Customer create(Customer customer){
        return customerDAO.save(customer);
    }

    public List<Customer> findAll(){return customerDAO.findAll();}
}
