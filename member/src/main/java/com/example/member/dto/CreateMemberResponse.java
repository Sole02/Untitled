package com.example.member.dto;

import lombok.Getter;

@Getter
public class CreateMemberResponse {

    private final Long id;
    private final String name;

    public CreateMemberResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
