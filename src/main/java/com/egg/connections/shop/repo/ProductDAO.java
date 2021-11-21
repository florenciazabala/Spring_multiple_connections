package com.egg.connections.shop.repo;

import com.egg.connections.shop.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductDAO extends JpaRepository<Product,Integer> {

}
