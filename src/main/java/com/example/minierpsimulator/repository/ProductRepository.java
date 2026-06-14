package com.example.minierpsimulator.repository;

import com.example.minierpsimulator.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}