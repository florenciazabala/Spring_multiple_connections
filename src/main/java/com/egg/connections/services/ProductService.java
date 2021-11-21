package com.egg.connections.services;

import com.egg.connections.shop.repo.ProductDAO;
import com.egg.connections.shop.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductDAO productDAO;

    public Product create(Product product){
        return productDAO.save(product);
    }

    public List<Product> findAll(){return  productDAO.findAll();}
}
