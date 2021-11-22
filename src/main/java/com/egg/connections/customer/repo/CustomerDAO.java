package com.egg.connections.customer.repo;

import com.egg.connections.customer.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDAO extends JpaRepository<Customer,Integer> {

}
