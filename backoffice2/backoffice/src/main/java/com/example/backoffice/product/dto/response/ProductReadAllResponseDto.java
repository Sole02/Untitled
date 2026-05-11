package com.example.backoffice.product.dto.response;

import com.example.backoffice.product.entity.Product;

public class ProductReadAllResponseDto {

    private final Long id;
    private final String name;
    private final int price;
    private final String adminName;

    public ProductReadAllResponseDto(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.adminName = product.getAdmin().getName();
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
    public String getAdmin_id() {
        return adminName;
    }
}
