package com.example.test.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.test.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // Custom queries or methods can be added here if needed
    @Query("SELECT p FROM Product p WHERE p.usenot = true")
    List<Product> findAll();

    @Query("SELECT p FROM Product p WHERE p.id = :id and p.usenot = true")
    Optional<Product> findById(@Param("id") Long id);
}
