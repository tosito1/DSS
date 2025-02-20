package com.example.demo.controller;

import java.util.List;  

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;


import com.example.demo.model.Product;


import com.example.demo.sercive.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductControllerAPI {

    private final ProductService productService;

    public ProductControllerAPI(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> listProductsForApi() {
        List<Product> products = productService.getAllProducts();

        if (products.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        // Construir la lista de productos con enlaces
        List<Map<String, Object>> productList = products.stream().map(product -> {
            Map<String, Object> productMap = new HashMap<>();
            productMap.put("name", product.getName());
            productMap.put("price", product.getPrice());
            productMap.put("_links", createProductLinks(product.getId()));
            return productMap;
        }).collect(Collectors.toList());

        // Construir el cuerpo de la respuesta
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("_embedded", Map.of("products", productList));
        responseBody.put("_links", createGlobalLinks());
        responseBody.put("page", createPageInfo(products.size()));

        return ResponseEntity.ok(responseBody);
    }
    
    private Map<String, Object> createProductLinks(Long productId) {
        String productUrl = "http://localhost:8080/api/products/" + productId;
        return Map.of(
            "self", Map.of("href", productUrl),
            "product", Map.of("href", productUrl)
        );
    }

    private Map<String, Object> createGlobalLinks() {
        return Map.of(
            "self", Map.of("href", "http://localhost:8080/api/products?page=0&size=20"),
            "profile", Map.of("href", "http://localhost:8080/api/profile/products"),
            "search", Map.of("href", "http://localhost:8080/api/products/search")
        );
    }

    private Map<String, Object> createPageInfo(int totalElements) {
        int size = 20;
        int totalPages = (int) Math.ceil((double) totalElements / size);
        return Map.of(
            "size", size,
            "totalElements", totalElements,
            "totalPages", totalPages,
            "number", 0
        );
    }
}