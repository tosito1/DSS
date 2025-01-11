package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository; 

import com.example.demo.model.Product;

//@RepositoryRestResource(collectionResourceRel="tasks",path="tasks")
//@Repository
public interface ProductRepo extends JpaRepository<Product, Long>{

}
