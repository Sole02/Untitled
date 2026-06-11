package com.example.chatservice.common.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class ChatMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User sender;

    private String content;
    private LocalDateTime createAt;

    public ChatMessage(User user, String content) {
        this.sender = user;
        this.content = content;
        this.createAt = LocalDateTime.now();
    }
}
