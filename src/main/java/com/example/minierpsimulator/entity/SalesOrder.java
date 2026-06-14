package com.example.minierpsimulator.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class SalesOrder {

    @Id
    private String orderId;

    private String customerName;
    private String sku;
    private int qty;
    private String status;

    public SalesOrder() {
    }

    public SalesOrder(String orderId, String customerName, String sku, int qty, String status) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.sku = sku;
        this.qty = qty;
        this.status = status;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getSku() {
        return sku;
    }

    public int getQty() {
        return qty;
    }

    public String getStatus() {
        return status;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}