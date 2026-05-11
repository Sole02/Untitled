package com.example.backoffice.product.dto.response;

import java.util.List;

public class ProductListResponseDto {

    private final List<ProductReadResponseDto> productLsit;

    public ProductListResponseDto(List<ProductReadResponseDto> productLsit) {
    this.productLsit = productLsit;
    }

    public List<ProductReadResponseDto> getProductLsit() {
        return productLsit;
    }
}
