package com.example.backoffice.Product.entity;

import com.example.backoffice.Admin.entity.Admin;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "products")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

    private  String name;
    private Integer price;

    public Product(String name, Integer price, Admin admin) {
        this.name = name;
        this.price = price;
        this.admin = admin;
    }

    public void productUpdate(String name, Integer price) {
        this.name = name;
        this.price = price;
    }
}
