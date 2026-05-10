package com.example.backoffice.admin.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "admins")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private boolean isDeleted;

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

    // 소프트 딜리트
    // 삭제 시 true
    public void adminDelete() {
        this.isDeleted = true;
    }
}
