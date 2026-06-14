package com.example.minierpsimulator.service;

import com.example.minierpsimulator.dto.SalesOrderRequest;
import com.example.minierpsimulator.entity.Product;
import com.example.minierpsimulator.entity.SalesOrder;
import com.example.minierpsimulator.repository.ProductRepository;
import com.example.minierpsimulator.repository.SalesOrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final ProductRepository productRepository;
    private final SalesOrderRepository salesOrderRepository;

    public OrderService(ProductRepository productRepository,
                        SalesOrderRepository salesOrderRepository) {
        this.productRepository = productRepository;
        this.salesOrderRepository = salesOrderRepository;
    }

    public String createOrder(SalesOrderRequest request) {

        Product product =
                productRepository.findById(request.getSku())
                        .orElseThrow(() ->
                                new RuntimeException("Product not found"));

        if (product.getInventoryQty() < request.getQty()) {
            return "Insufficient inventory";
        }

        product.setInventoryQty(
                product.getInventoryQty() - request.getQty());

        productRepository.save(product);

        SalesOrder order = new SalesOrder(
                request.getOrderId(),
                request.getCustomerName(),
                request.getSku(),
                request.getQty(),
                "COMPLETED"
        );

        salesOrderRepository.save(order);

        return "Order Created";
    }
}