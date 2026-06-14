package com.example.minierpsimulator.controller;

import com.example.minierpsimulator.entity.Product;
import com.example.minierpsimulator.repository.ProductRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SetupController {

    private final ProductRepository productRepository;

    public SetupController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/setup")
    public String setupData() {
        productRepository.save(new Product("LAPTOP-001", "Business Laptop", 10));
        productRepository.save(new Product("MOUSE-001", "Wireless Mouse", 50));

        return "Mini ERP setup completed";
    }
}