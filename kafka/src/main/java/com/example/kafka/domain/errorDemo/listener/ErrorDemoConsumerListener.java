package com.example.kafka.domain.errorDemo.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ErrorDemoConsumerListener {

    @KafkaListener(
            topics = "error-demo",
            groupId = "error-demo-group",
            containerFactory = "errorDemoDLTKafkaListenerContainerFactory"
    )
    public void consume(String message) {
        log.info("[error-demo] 받은 메시지: {}", message);

        if (message.contains("error")) {
            log.info("에러가 포함된 메시지이므로 예외를 발생시킵니다: {}", message);
            throw new RuntimeException("테스트용 예외");
        }

        log.info("정상 처리 완료: {}", message);
    }
}