package com.example.member.dto;

import lombok.Getter;

@Getter
public class UpdateMemberResponse {

    private final Long id;
    private final String name;

    public UpdateMemberResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
