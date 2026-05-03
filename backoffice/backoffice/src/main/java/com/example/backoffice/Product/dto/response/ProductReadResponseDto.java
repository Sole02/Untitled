package com.example.backoffice.Product.dto.response;

import lombok.Getter;

@Getter
public class ProductReadResponseDto {

    private final Long id;
    private final String adminName;
    private final String name;
    private final Integer price;

    public ProductReadResponseDto(Long id, String adminName, String name, Integer price) {
        this.id = id;
        this.adminName = adminName;
        this.name = name;
        this.price = price;
    }
}
