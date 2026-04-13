package com.example.member.dto;

import lombok.Getter;

@Getter
public class GetMemberResponse {

    private final Long id;
    private final String Name;

    public GetMemberResponse(Long id, String name) {
        this.id = id;
        Name = name;
    }
}
