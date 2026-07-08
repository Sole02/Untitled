package com.example.kafka.domain.simple.model.kafka;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SimpleEvent {

    // 실제 메시지 내용
    private String message;

    // 작업자
    private String worker;

    // 이벤트 생성 시각
    private LocalDateTime createdAt;

    public SimpleEvent(String message) {
        this.message = message;
        this.worker = "me";
        this.createdAt = LocalDateTime.now();
    }
}