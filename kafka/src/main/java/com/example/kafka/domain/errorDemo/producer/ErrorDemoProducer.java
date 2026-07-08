package com.example.kafka.domain.errorDemo.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ErrorDemoProducer {

    private static final String TOPIC_ERROR_DEMO = "error-demo";

    private final KafkaTemplate<String, String> stringStringkafkaTemplate;

    public void send(String message) {
        stringStringkafkaTemplate.send(TOPIC_ERROR_DEMO, message);
    }
}
