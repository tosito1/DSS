package com.example.demo.sercive;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import com.example.demo.model.Product;
import com.example.demo.repo.ProductRepo;

@Service
public class DatabaseExportService {

    @Autowired
    private ProductRepo productRepo;

    public byte[] exportDatabaseToSql() {
        List<Product> products = productRepo.findAll();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        StringBuilder sqlBuilder = new StringBuilder();
        for (Product product : products) {
            sqlBuilder.append("INSERT INTO product (name, price) VALUES ('")
                      .append(product.getName()).append("', ")
                      .append(product.getPrice()).append(");\n");
        }

        try {
            outputStream.write(sqlBuilder.toString().getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace(); // Manejo básico de errores
        }

        return outputStream.toByteArray();
    }
}