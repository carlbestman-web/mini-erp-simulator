package com.example.minierpsimulator.controller;

import com.example.minierpsimulator.dto.SalesOrderRequest;
import com.example.minierpsimulator.entity.Product;
import com.example.minierpsimulator.repository.ProductRepository;
import com.example.minierpsimulator.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class WebController {

    private final ProductRepository productRepository;
    private final OrderService orderService;

    public WebController(ProductRepository productRepository,
                         OrderService orderService) {
        this.productRepository = productRepository;
        this.orderService = orderService;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        model.addAttribute("orderRequest", new SalesOrderRequest());
        return "index";
    }

    @PostMapping("/web/orders")
    public String createOrder(@ModelAttribute SalesOrderRequest orderRequest,
                              Model model) {

        String result = orderService.createOrder(orderRequest);

        model.addAttribute("message", result);
        model.addAttribute("products", productRepository.findAll());
        model.addAttribute("orderRequest", new SalesOrderRequest());

        return "index";
    }
}