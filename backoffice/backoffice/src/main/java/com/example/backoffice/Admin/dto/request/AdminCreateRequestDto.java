package com.example.backoffice.Admin.dto.request;

import lombok.Getter;

@Getter
public class AdminCreateRequestDto {
    private String name;

    public AdminCreateRequestDto(String name) {
        this.name = name;
    }
}
