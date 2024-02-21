package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ProductModel 
{
    @Id
    private int productId;
    private  String productName;
    private  double price;
    private String description;
    private int quantity;

    
    public ProductModel() {
    }

    public ProductModel(int productId, String productName, double price, String description, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    


    
}
