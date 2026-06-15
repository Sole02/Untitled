package com.example.chatservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ChatMessageDto {

    private Long roomId;
    private Long senderId;
    private String content;
}
