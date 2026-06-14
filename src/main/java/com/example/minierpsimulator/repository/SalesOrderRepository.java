package com.example.minierpsimulator.repository;

import com.example.minierpsimulator.entity.SalesOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesOrderRepository extends JpaRepository<SalesOrder, String> {
}