package com.example.backoffice.product.dto.request;

public class ProductCreateRequestDto {

    private String name;
    private int price;
    private Long adminId;

    public ProductCreateRequestDto(String name, int price, Long adminId) {
        this.name = name;
        this.price = price;
        this.adminId = adminId;
    }

    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }
    public Long getAdminId() {
        return adminId;
    }
}
