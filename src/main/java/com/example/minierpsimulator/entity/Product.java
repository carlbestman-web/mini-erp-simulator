package com.example.minierpsimulator.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Product {

    @Id
    private String sku;

    private String name;
    private int inventoryQty;

    public Product() {
    }

    public Product(String sku, String name, int inventoryQty) {
        this.sku = sku;
        this.name = name;
        this.inventoryQty = inventoryQty;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public int getInventoryQty() {
        return inventoryQty;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInventoryQty(int inventoryQty) {
        this.inventoryQty = inventoryQty;
    }
}