package com.example.backoffice.admin.dto.request;

public class AdminCreateRequestDto {
    private String name;

    public AdminCreateRequestDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
