package com.example.chatservice.domain.controller;

import com.example.chatservice.common.entity.ChatMessage;
import com.example.chatservice.common.entity.ChatRoom;
import com.example.chatservice.common.entity.User;
import com.example.chatservice.domain.model.ChatMessageDto;
import com.example.chatservice.domain.repository.ChatMessageRepository;
import com.example.chatservice.domain.repository.ChatRoomRepository;
import com.example.chatservice.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.message.SimpleMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ChatController {

    private final UserRepository userRepository;
    private final ChatMessageRepository chatMessageRepository;
    private final ChatRoomRepository chatRoomRepository;
    private final SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/chat.sand")
    public void sand(ChatMessageDto dto) {

        User sender = userRepository.findById(dto.getSenderId())
                .orElseThrow();
        ChatRoom chatRoom = chatRoomRepository.findById(dto.getRoomId())
                .orElseThrow();

        ChatMessage message = new ChatMessage(sender, chatRoom, dto.getContent());
        chatMessageRepository.save(message);

        messagingTemplate.convertAndSend("/sub/chat", dto);
    }
}
