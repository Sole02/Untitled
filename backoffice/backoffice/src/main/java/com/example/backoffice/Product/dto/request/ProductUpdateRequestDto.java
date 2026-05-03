package com.example.backoffice.Product.dto.request;

import lombok.Getter;

@Getter
public class ProductUpdateRequestDto {
    private String name;
    private Integer price;

    public ProductUpdateRequestDto(String name, Integer price) {
        this.name = name;
        this.price = price;
    }
}
