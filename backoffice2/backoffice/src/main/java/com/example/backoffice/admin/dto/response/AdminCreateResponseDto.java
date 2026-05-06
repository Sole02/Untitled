package com.example.backoffice.admin.dto.response;

public class AdminCreateResponseDto {
    private final Long id;
    private final String name;

    public AdminCreateResponseDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
}
