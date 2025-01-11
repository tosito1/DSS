package com.example.demo.controller;


import org.apache.pdfbox.pdmodel.PDDocument; 
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Product;
import com.example.demo.sercive.CartService;
import com.example.demo.sercive.ProductService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private ProductService productService; 

    @Autowired
    private CartService cartService;

    @GetMapping
    public String showCart(Model model, HttpSession session) {
        // Obtiene la autenticación actual
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Extrae los roles del usuario
        String role = authentication.getAuthorities().stream()
            .map(GrantedAuthority::getAuthority)
            .findFirst()
            .orElse("ROLE_USER"); // Si no tiene roles, por defecto será USER

        // Añade el rol al modelo
        model.addAttribute("userRole", role);
        model.addAttribute("cartProducts", cartService.getProducts());
        return "cart";
    }

    @GetMapping("/add/{id}") // Mapea a /cart/add/{id}
    public String addFromCart(@PathVariable Long id, HttpSession session) {
        cartService.addProduct(productService.getProductById(id).get()); // Asegúrate de que este método existe
        return "redirect:/catalogo";
    }

    @PostMapping("/remove/{id}")
    public String removeFromCart(@PathVariable Long id, HttpSession session) {
        cartService.removeProduct(id);
        return "redirect:/cart";
    }


    @GetMapping("/export")
    public void exportCart(HttpServletResponse response) throws IOException {
    	response.setContentType("application/pdf");
    	response.setHeader("Content-Disposition", "attachment; filename=carrito.pdf");

    	try (PDDocument document = new PDDocument()) {
    	    PDPage page = new PDPage();
    	    document.addPage(page);
    	    PDPageContentStream contentStream = new PDPageContentStream(document, page);
    	    
    	    // Estilo del título
    	    contentStream.beginText();
    	    contentStream.setFont(PDType1Font.HELVETICA_BOLD, 24);
    	    contentStream.setNonStrokingColor(0, 51, 102); // Color azul oscuro
    	    contentStream.newLineAtOffset(25, 750);
    	    contentStream.showText("Carrito de Compras");
    	    contentStream.endText();
    	    
    	    // Línea separadora
    	    contentStream.setStrokingColor(0, 51, 102); // Color azul oscuro
    	    contentStream.moveTo(25, 740);
    	    contentStream.lineTo(575, 740);
    	    contentStream.stroke();
    	    
    	    List<Product> cartProducts = cartService.getProducts();
    	    int yOffset = 700;  
    	    double totalPrice = 0.0; 
    	    
    	    // Configurar fuentes y colores
    	    contentStream.setFont(PDType1Font.HELVETICA, 12);
    	    contentStream.setNonStrokingColor(0, 0, 0); // Color negro
    	    
    	    for (Product product : cartProducts) {
    	        contentStream.beginText();
    	        contentStream.newLineAtOffset(35, yOffset);
    	        contentStream.showText("ID: " + product.getId() + ", Nombre: " + product.getName() + ", Precio: $" + product.getPrice());
    	        contentStream.endText();
    	        
    	        // Calcular total
    	        totalPrice += product.getPrice();
    	        
    	        yOffset -= 20; // Espacio entre productos
    	    }
    	    
    	    // Mostrar el total del carrito
    	    contentStream.beginText();
    	    contentStream.setFont(PDType1Font.HELVETICA_BOLD, 14);
    	    contentStream.newLineAtOffset(35, yOffset - 20);
    	    contentStream.setNonStrokingColor(0, 51, 102); // Color azul oscuro
    	    contentStream.showText("Total: $" + String.format("%.2f", totalPrice));
    	    contentStream.endText();
    	    
    	    // Pie de página
    	    contentStream.beginText();
    	    contentStream.setFont(PDType1Font.HELVETICA_OBLIQUE, 10);
    	    contentStream.newLineAtOffset(25, 50);
    	    contentStream.showText("Generado el: " + LocalDate.now());
    	    contentStream.endText();
    	    
    	    contentStream.close();
    	    document.save(response.getOutputStream());
    	}


    }
}