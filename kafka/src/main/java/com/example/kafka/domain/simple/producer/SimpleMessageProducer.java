package com.example.kafka.domain.simple.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SimpleMessageProducer {

    // Topic에 데이터를 넣기 위함.
    private static final String TOPIC_SIMPLE = "simple-messages";

    // kafka Config에서 설정한 KafkaTemplate<String, String> 설정 불러오기
    private final KafkaTemplate<String, String> stringStringKafkaTemplate;

    public void send(String message) {
        stringStringKafkaTemplate.send(TOPIC_SIMPLE, message);
    }
}
