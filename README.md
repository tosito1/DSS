# Proyecto de Aplicación Web con Spring Boot

Esta aplicación web utiliza Spring Boot para proporcionar una interfaz de catálogo de productos con acceso limitado a funcionalidades administrativas según el rol del usuario. 

## Características Principales

- **Inicio de Sesión**: Los usuarios pueden iniciar sesión con credenciales predefinidas y acceder a diferentes funcionalidades según su rol.
- **Roles de Usuario**:
  - **USER**: Acceso limitado para ver el catálogo de productos.
  - **ADMIN**: Acceso a funcionalidades avanzadas, como la exportación de la base de datos y la gestión de productos.
- **Exportación de Base de Datos**: Solo los usuarios con rol `ADMIN` pueden exportar la base de datos en formato SQL.
- **Carrito de Compras**: Los usuarios pueden ver y gestionar su carrito de compras, con un indicador de la cantidad de productos en el carrito.
- **Seguridad**: Configuración de seguridad con roles `USER` y `ADMIN` usando Spring Security.

## Requisitos Previos

Para ejecutar este proyecto, asegúrate de tener instalado lo siguiente:

- **Java 21**
- **Maven** (para la gestión de dependencias y construcción del proyecto)
- **Spring Tool Suite**

## Configuración de Base de Datos

spring.datasource.url=jdbc:h2:file:./DSS/testdb;DB_CLOSE_ON_EXIT=FALSE
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.sql.init.platform=h2

## Usuarios Creados

- **Usuario**: Nombre de usuario: user, password: password y rol: USER
- **Administrador**: Nombre de usuario: admin, password: admin y rol: ADMIN
