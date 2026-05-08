package com.example.backoffice.product.dto.response;

public class ProductUpdateResponseDto {

    private final Long id;
    private final String name;
    private final int price;

    public ProductUpdateResponseDto(Long id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
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
}
