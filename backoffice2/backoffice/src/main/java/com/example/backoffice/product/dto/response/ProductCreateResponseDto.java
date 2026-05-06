package com.example.backoffice.product.dto.response;

public class ProductCreateResponseDto {
    private final Long id;
    private final String name;
    private final int price;
    private final String adminName;

    public ProductCreateResponseDto(Long id, String name, int price, String adminName) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.adminName = adminName;
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
    public String getAdminName() {
        return adminName;
    }
}
