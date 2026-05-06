package com.example.backoffice.product.entity;

import com.example.backoffice.admin.entity.Admin;
import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int price;

    @ManyToOne(fetch = FetchType.LAZY) // 다대일 관계
    @JoinColumn(name = "admin_id") // FK이름 설정
    private Admin admin;

    public Product() {}

    public Product(String name, int price, Admin admin) {
        this.name = name;
        this.price = price;
        this.admin = admin;
    }

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }
    public Admin getAdmin() {
        return admin;
    }
}
