package com.example.backoffice.admin.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "admins")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Admin() {}

    public Admin(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
}
