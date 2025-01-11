package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.sercive.DatabaseExportService;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private DatabaseExportService databaseExportService;

    @GetMapping("/export")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<byte[]> exportDatabase() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("Roles del usuario autenticado: " + authentication.getAuthorities());

        boolean isAdmin = authentication.getAuthorities().stream()
            .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_ADMIN"));

        if (isAdmin) {
            // Exportar la base de datos solo si es ADMIN (controlado por @PreAuthorize)
            byte[] sqlData = databaseExportService.exportDatabaseToSql();
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"export.sql\"")
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(sqlData);
        } else {
            // Si ocurre un error al exportar, devolver un 500
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

}