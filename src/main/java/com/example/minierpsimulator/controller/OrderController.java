package com.example.minierpsimulator.controller;

import com.example.minierpsimulator.dto.SalesOrderRequest;
import com.example.minierpsimulator.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public String createOrder(
            @RequestBody SalesOrderRequest request) {

        return orderService.createOrder(request);
    }
}