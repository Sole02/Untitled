package com.example.backoffice.Product.dto.response;

import lombok.Getter;

@Getter
public class ProductReadAllResponseDto {

    private final Long id;
    private final String name;
    private final Integer price;

    public ProductReadAllResponseDto(Long id, String name, Integer price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
