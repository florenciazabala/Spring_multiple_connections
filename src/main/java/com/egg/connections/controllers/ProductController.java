package com.egg.connections.controllers;

import com.egg.connections.services.ProductService;
import com.egg.connections.shop.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public List<Product> getAll(){return productService.findAll();}

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public Product create(@RequestBody Product product){
        return productService.create(product);
    }

}
