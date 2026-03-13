# Desarrollo de Sistemas de Software Basados en Componentes y Servicios (DSS)

Este repositorio contiene las prácticas realizadas en la asignatura **Desarrollo de Sistemas de Software basados en Componentes y Servicios** del Máster en Ingeniería Informática.

El objetivo de la asignatura es aprender a diseñar e implementar sistemas distribuidos utilizando diferentes paradigmas y tecnologías de componentes, servicios, aplicaciones web, móviles y tecnologías semánticas.

A lo largo de las prácticas se desarrollan aplicaciones completas utilizando arquitecturas modernas como **servicios web, arquitecturas orientadas a servicios (SOA), aplicaciones web con backend y frontend, aplicaciones móviles y ontologías semánticas**.

---

# Contenido del repositorio

El repositorio se divide en cinco prácticas independientes, cada una centrada en un paradigma o tecnología diferente.

## Práctica 1 — Aplicación Web con Spring Boot

En esta práctica se desarrolla una aplicación web completa basada en **Spring Boot** que implementa un catálogo de productos con autenticación y control de acceso basado en roles.

### Características principales

* Aplicación web desarrollada con **Spring Boot**
* Sistema de autenticación de usuarios
* Gestión de roles (**USER** y **ADMIN**)
* Catálogo de productos
* Carrito de compra
* Exportación de base de datos en formato SQL (solo administrador)
* Seguridad implementada mediante **Spring Security**
* Base de datos **H2**

### Tecnologías utilizadas

* Java 21
* Spring Boot
* Spring Security
* Maven
* H2 Database
* Spring Tool Suite

### Conceptos aprendidos

* Desarrollo de aplicaciones web con Spring Boot
* Configuración de seguridad con Spring Security
* Autenticación y autorización basada en roles
* Integración de bases de datos en aplicaciones Spring
* Arquitectura backend para aplicaciones web

---

## Práctica 2 — Arquitectura SOA con Servicios Web

Esta práctica introduce el paradigma **SOA (Service-Oriented Architecture)** mediante la implementación de servicios web empresariales utilizando herramientas de Oracle.

Se desarrollan varios sistemas basados en servicios distribuidos que se comunican mediante **SOAP**.

### Ejemplo incluido

Se incluye un ejemplo proporcionado por el profesor que implementa una **calculadora distribuida** utilizando servicios web.

### Sistemas desarrollados

Durante la práctica se desarrollan varios escenarios de integración de servicios:

* Sistema de búsqueda de vuelos que integra servicios de diferentes aerolíneas
* Sistema de compra distribuido basado en servicios

### Tecnologías utilizadas

* Oracle JDeveloper
* Oracle SOA Suite
* BPEL (Business Process Execution Language)
* SOAP Web Services
* WSDL
* XML Schema

### Conceptos aprendidos

* Arquitectura orientada a servicios (SOA)
* Definición de contratos de servicios mediante WSDL
* Orquestación de procesos de negocio mediante BPEL
* Integración de servicios distribuidos
* Comunicación basada en XML y SOAP

---

## Práctica 3 — Aplicación Android (Carrito de Compra)

En esta práctica se desarrolla una aplicación móvil Android que interactúa con el backend desarrollado en la práctica 1.

La aplicación permite a los usuarios consultar productos, gestionar un carrito de compra y localizar tiendas en el mapa.

### Características principales

* Aplicación Android desarrollada en **Android Studio**
* Integración con el backend de la práctica 1
* Sincronización con el catálogo web
* Sistema de carrito de compra
* Localización de tiendas mediante mapas

### Tecnologías utilizadas

* Kotlin
* Android Studio
* API REST
* Google Maps
* Arquitectura cliente-servidor

### Conceptos aprendidos

* Desarrollo de aplicaciones móviles Android
* Consumo de APIs desde aplicaciones móviles
* Integración entre aplicaciones móviles y backend web
* Arquitectura cliente-servidor
* Geolocalización en aplicaciones móviles

---

## Práctica 4 — Creación de una Ontología con Protégé

En esta práctica se desarrolla una **ontología semántica** para modelar información sobre libros, autores y géneros.

La ontología se crea utilizando la herramienta Protégé y el lenguaje **OWL**.

### Modelo desarrollado

La ontología incluye entidades como:

* Libro
* Autor
* Género
* Editorial

También se definen jerarquías, propiedades y restricciones para representar el dominio de una librería.

### Tecnologías utilizadas

* Protégé
* OWL (Web Ontology Language)
* RDF
* Razonadores semánticos (HermiT / Fact++)

### Conceptos aprendidos

* Modelado semántico de información
* Creación de ontologías
* Definición de clases y propiedades
* Restricciones y razonamiento automático
* Representación del conocimiento

---

## Práctica 5 — Consultas SPARQL sobre Ontologías

Esta práctica utiliza la ontología desarrollada en la práctica 4 para realizar consultas utilizando **SPARQL**.

Las consultas permiten extraer información compleja de la ontología sobre libros, lectores y compras.

### Ejemplos de consultas

* Lectores que han comprado libros de ciencia ficción
* Títulos de libros de un género concreto
* Libros con una valoración determinada
* Total de libros comprados
* Suma del gasto realizado por cada lector

### Tecnologías utilizadas

* SPARQL
* Protégé
* OWL
* RDF

### Conceptos aprendidos

* Lenguajes de consulta para datos semánticos
* Extracción de información en ontologías
* Consultas agregadas
* Integración entre ontologías y consultas semánticas

---

# Tecnologías utilizadas en el proyecto

Lenguajes

* Java
* Kotlin
* XML
* SPARQL

Frameworks y herramientas

* Spring Boot
* Spring Security
* Android Studio
* Oracle JDeveloper
* Oracle SOA Suite
* Protégé

Arquitecturas y paradigmas

* Arquitectura cliente-servidor
* Arquitectura orientada a servicios (SOA)
* Aplicaciones web backend
* Aplicaciones móviles
* Web semántica

---

# Objetivos de aprendizaje

Las prácticas de esta asignatura están diseñadas para comprender cómo construir sistemas software utilizando diferentes enfoques de componentes y servicios.

Entre los principales conocimientos adquiridos se encuentran:

* Desarrollo de aplicaciones web seguras
* Integración entre aplicaciones web y móviles
* Arquitecturas orientadas a servicios
* Orquestación de servicios empresariales
* Representación semántica del conocimiento
* Consultas sobre datos semánticos

---

# Autor

Tosé
Máster en Ingeniería Informática
