package com.example.backoffice.Admin.dto.response;

import lombok.Getter;

@Getter
public class AdminCreateResponseDto {

    private final Long id;
    private final String name;

    public AdminCreateResponseDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
