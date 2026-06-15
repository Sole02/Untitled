package com.example.chatservice.domain.controller;

import com.example.chatservice.common.entity.ChatRoom;
import com.example.chatservice.domain.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chat/rooms")
@RequiredArgsConstructor
public class ChatRoomController {

    private final ChatRoomRepository chatRoomRepository;

    @GetMapping
    public List<ChatRoom> getAll() {
        return chatRoomRepository.findAll();
    }

    @PostMapping
    public ChatRoom create(@RequestParam String name) {
        ChatRoom room = new ChatRoom(name);
        return chatRoomRepository.save(room);
    }
}