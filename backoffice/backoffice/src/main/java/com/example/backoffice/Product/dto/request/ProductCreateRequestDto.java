package com.example.backoffice.Product.dto.request;

import com.example.backoffice.Admin.entity.Admin;
import lombok.Getter;

@Getter
public class ProductCreateRequestDto {
    private Long adminId;
    private String name;
    private Integer price;

    public ProductCreateRequestDto(Long adminId, String name, Integer price) {
        this.adminId = adminId;
        this.name = name;
        this.price = price;
    }
}
