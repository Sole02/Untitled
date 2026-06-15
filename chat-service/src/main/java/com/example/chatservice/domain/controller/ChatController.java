package com.example.chatservice.domain.controller;

import com.example.chatservice.common.config.redis.ChatRedisPublisher;
import com.example.chatservice.common.config.redis.RedisChatMessage;
import com.example.chatservice.common.entity.ChatMessage;
import com.example.chatservice.common.entity.ChatRoom;
import com.example.chatservice.common.entity.User;
import com.example.chatservice.common.interceptor.AuthenticatedUser;
import com.example.chatservice.domain.model.ChatMessageDto;
import com.example.chatservice.domain.model.TypingIndicatorDto;
import com.example.chatservice.domain.repository.ChatMessageRepository;
import com.example.chatservice.domain.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class ChatController {

    private final ChatMessageRepository chatMessageRepository;
    private final ChatRedisPublisher chatRedisPublisher;
    private final ChatRoomRepository chatRoomRepository;
    private final SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/chat.send")
    public void send(ChatMessageDto dto, Principal principal) {

        User sender = AuthenticatedUser.fromPrincipal(principal);

        ChatRoom room = chatRoomRepository.findById(dto.getRoomId())
                .orElseThrow();

        ChatMessage message = new ChatMessage(sender, room, dto.getContent());
        chatMessageRepository.save(message);

        RedisChatMessage redisMessage = new RedisChatMessage(
                message.getChatRoom().getId(),
                message.getSender().getId(),
                message.getSender().getName(),
                message.getContent()
        );

        chatRedisPublisher.publish(room.getId(), redisMessage);

    }

    @MessageMapping("/chat.typing")
    public void typing(TypingIndicatorDto dto, Principal principal) {
        User user = AuthenticatedUser.fromPrincipal(principal);

        dto.setUserId(user.getId());
        dto.setUserName(user.getName());

        // 타이핑 상태를 해당 채팅방의 다른 사용자들에게 브로드캐스트
        messagingTemplate.convertAndSend("/sub/chat/" + dto.getRoomId() + "/typing", dto);
    }
}
