package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;

import com.example.demo.sercive.ProductService;

import jakarta.servlet.http.HttpSession;


@Controller
public class RootUriController {

    @Autowired
    private ProductService productService; 

    @GetMapping("/")
    public String index(Model model) {
        // Obtiene la autenticación actual
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Extrae los roles del usuario
        String role = authentication.getAuthorities().stream()
            .map(GrantedAuthority::getAuthority)
            .findFirst()
            .orElse("ROLE_USER"); // Si no tiene roles, por defecto será USER

        // Añade el rol al modelo
        model.addAttribute("userRole", role);
        model.addAttribute("products", productService.getAllProducts());
        return "catalogo";
    }

    @GetMapping("/index")
    public String index2(Model model, HttpSession session) {
        // Obtiene la autenticación actual
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Extrae los roles del usuario
        String role = authentication.getAuthorities().stream()
            .map(GrantedAuthority::getAuthority)
            .findFirst()
            .orElse("ROLE_USER"); // Si no tiene roles, por defecto será USER

        // Añade el rol al modelo
        model.addAttribute("userRole", role);
        model.addAttribute("products", productService.getAllProducts());
        return "catalogo";
    }

    @GetMapping("/catalogo")
    public String catalogo(Model model) { 
        // Obtiene la autenticación actual
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Extrae los roles del usuario
        String role = authentication.getAuthorities().stream()
            .map(GrantedAuthority::getAuthority)
            .findFirst()
            .orElse("ROLE_USER"); // Si no tiene roles, por defecto será USER

        // Añade el rol al modelo
        model.addAttribute("userRole", role);
        model.addAttribute("products", productService.getAllProducts());
        return "catalogo"; // Asegúrate de que este sea el nombre correcto de tu plantilla
    }
    
    @GetMapping("/login")
    public String getMethodName(@RequestParam String param) {
        return "login";
    }
    
}
