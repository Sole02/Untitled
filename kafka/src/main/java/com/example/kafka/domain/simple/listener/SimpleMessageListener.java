package com.example.kafka.domain.simple.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SimpleMessageListener {

    // Consumer 등록
    @KafkaListener(
            topics = "simple-messages",
            groupId = "simple-group",
            containerFactory = "stringKafkaListenerContainerFactory"
    )
    public void consume(String message) {
        log.info("받은 메시지: {}", message);
    }
}