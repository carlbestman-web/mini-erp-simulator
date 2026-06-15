package com.example.minierpsimulator.controller;

import com.example.minierpsimulator.dto.SalesOrderRequest;
import com.example.minierpsimulator.entity.Product;
import com.example.minierpsimulator.repository.IncidentTicketRepository;
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
    private final IncidentTicketRepository incidentTicketRepository;

    public WebController(ProductRepository productRepository,
                         OrderService orderService,
                         IncidentTicketRepository incidentTicketRepository) {
        this.productRepository = productRepository;
        this.orderService = orderService;
        this.incidentTicketRepository = incidentTicketRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        loadDashboard(model);
        return "index";
    }

    @PostMapping("/web/orders")
    public String createOrder(@ModelAttribute SalesOrderRequest orderRequest,
                              Model model) {

        String result = orderService.createOrder(orderRequest);

        loadDashboard(model);
        model.addAttribute("message", result);

        return "index";
    }

    private void loadDashboard(Model model) {
        List<Product> products = productRepository.findAll();

        model.addAttribute("products", products);
        model.addAttribute("incidents", incidentTicketRepository.findAll());
        model.addAttribute("orderRequest", new SalesOrderRequest());
    }
}