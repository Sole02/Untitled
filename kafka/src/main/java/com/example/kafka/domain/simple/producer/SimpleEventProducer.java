package com.example.kafka.domain.simple.producer;

import com.example.kafka.domain.simple.model.kafka.SimpleEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SimpleEventProducer {

    private static final String TOPIC = "simple-events";

    private final KafkaTemplate<String, SimpleEvent> eventKafkaTemplate;

    public void send(SimpleEvent event) {
        eventKafkaTemplate.send(TOPIC, event);
    }
}