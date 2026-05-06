package com.example.backoffice.product.dto.response;

import com.example.backoffice.product.entity.Product;

public class ProductReadAllResponseDto {
    // 속성
    private final Long id;
    private final String name;
    private final int price;
    private final String admin_id;

    public ProductReadAllResponseDto(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.admin_id = product.getAdmin().getName();
    }

    // 기능
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
        return admin_id;
    }
}
