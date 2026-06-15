package com.example.chatservice.domain.controller;

import com.example.chatservice.common.entity.ChatRoom;
import com.example.chatservice.domain.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chat/rooms")
@RequiredArgsConstructor
public class ChatRoomController {

    private final ChatRoomRepository chatRoomRepository;

    @PostMapping
    public ChatRoom create(@RequestParam String name) {
        ChatRoom room = new ChatRoom(name);
        return chatRoomRepository.save(room);
    }
}