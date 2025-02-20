package com.example.demo.model;

import jakarta.persistence.Entity; 
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id; 
    private String name; 
    private double price;

    public Product() {}
    
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {return this.name;}
    public double getPrice() {return this.price;}
    public Long getId() {return this.id;}

    public void setPrice(double price) {
        this.price = price;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
