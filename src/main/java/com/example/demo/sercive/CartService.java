package com.example.demo.sercive;

import org.springframework.stereotype.Service; 

import com.example.demo.model.Product;
import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {
    private List<Product> cart = new ArrayList<>();

    public void addProduct(Product product) {
        cart.add(product);
    }

    public void removeProduct(Long productId) {
        cart.removeIf(product -> product.getId().equals(productId));
    }

    public List<Product> getProducts() {
        return cart;
    }

    public void clearCart() {
        cart.clear();
    }
}

