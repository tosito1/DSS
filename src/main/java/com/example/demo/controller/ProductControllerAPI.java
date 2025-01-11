package com.example.demo.controller;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;


import com.example.demo.sercive.ProductService;

@RestController 
@RequestMapping("/api/products") 
public class ProductControllerAPI {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> listProductsForApi() {
        // Registra un mensaje en los logs para confirmar que el método es alcanzado
        System.out.println("Endpoint /api/products called");

        // Verifica si hay productos disponibles
        List<Product> products = productService.getAllProducts();
        if (products.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(products);
    }

}