package com.example.backoffice.Product.repository;

import com.example.backoffice.Product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
