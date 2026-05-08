package com.example.backoffice.product.dto.request;

public class ProductUpdateRequestDto {

    private String name;
    private int price;

    public ProductUpdateRequestDto(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }
}
