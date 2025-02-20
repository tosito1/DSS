package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.model.Product;
import com.example.demo.sercive.ProductService;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;



@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping
    public String listProducts(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("Roles del usuario autenticado: " + authentication.getAuthorities());

        boolean isAdmin = authentication.getAuthorities().stream()
            .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_ADMIN"));

        if (isAdmin) {
            model.addAttribute("products", productService.getAllProducts());
            return "products";
        }

        return "redirect:/index";
    }


    // @GetMapping("/add")
    // public String showNewProductForm(Model model) {
    //     model.addAttribute("product", new Product());
    //     return "formulario-producto";
    // }

    @PostMapping("/add")
    public String saveProduct(@ModelAttribute Product product) {
        System.out.println("Producto recibido: " + product.getName() + ", Precio: " + product.getPrice());
        productService.saveProduct(product);
        return "redirect:/products";
    }


    // @GetMapping("/edit/{id}")
    // public String showEditProductForm(@PathVariable Long id, Model model) {
    //     Product product = productService.getProductById(id)
    //             .orElseThrow(() -> new RuntimeException("Product not found"));
    //     model.addAttribute("product", product);
    //     return "formulario-producto"; // Esta es tu plantilla de formulario
    // }

    @PostMapping("/edit/{id}")
    public String updateProduct(@PathVariable Long id, @ModelAttribute Product product) {
        // product.setId(id);
        // productService.saveProduct(product);
        return "formulario-producto";
    }

    @PostMapping("/edit/confirm/{id}")
    public String updateProductConfirm(@PathVariable Long id, @ModelAttribute Product product) {
        System.out.println(id);
        product.setId(id);
        productService.saveProduct(product);
        return "redirect:/products";
    }

    @PostMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/products";
    }
}