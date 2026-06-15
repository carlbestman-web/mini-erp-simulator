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
    private final IncidentService incidentService;
    private final LoggingService loggingService;

    public OrderService(ProductRepository productRepository,
                        SalesOrderRepository salesOrderRepository,
                        IncidentService incidentService,
                        LoggingService loggingService) {
        this.productRepository = productRepository;
        this.salesOrderRepository = salesOrderRepository;
        this.incidentService = incidentService;
        this.loggingService = loggingService;
    }

    public String createOrder(SalesOrderRequest request) {

        Product product = productRepository.findById(request.getSku()).orElse(null);

        if (product == null) {

            incidentService.createIncident(
                    "MINI_ERP",
                    request.getOrderId(),
                    "PRODUCT_NOT_FOUND",
                    "P3",
                    "L1_SUPPORT",
                    "Sales order failed because SKU does not exist in product master data"
            );

            loggingService.log(
                    "ERROR",
                    "Order " + request.getOrderId()
                            + " failed. SKU not found: "
                            + request.getSku()
            );

            return "Order Failed: Product not found. Incident ticket created.";
        }

        if (product.getInventoryQty() < request.getQty()) {

            incidentService.createIncident(
                    "MINI_ERP",
                    request.getOrderId(),
                    "INSUFFICIENT_INVENTORY",
                    "P3",
                    "L1_SUPPORT",
                    "Sales order failed because requested quantity is greater than available inventory"
            );

            loggingService.log(
                    "ERROR",
                    "Order " + request.getOrderId()
                            + " failed. Requested="
                            + request.getQty()
                            + ", Available="
                            + product.getInventoryQty()
                            + ", SKU="
                            + request.getSku()
            );

            return "Order Failed: Insufficient inventory. Incident ticket created.";
        }

        product.setInventoryQty(product.getInventoryQty() - request.getQty());
        productRepository.save(product);

        SalesOrder order = new SalesOrder(
                request.getOrderId(),
                request.getCustomerName(),
                request.getSku(),
                request.getQty(),
                "COMPLETED"
        );

        salesOrderRepository.save(order);

        loggingService.log(
                "INFO",
                "Order " + request.getOrderId()
                        + " created successfully. SKU="
                        + request.getSku()
                        + ", Qty="
                        + request.getQty()
        );

        return "Order Created";
    }
}