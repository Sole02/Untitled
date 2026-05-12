package com.example.health;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@Slf4j
@RestController
public class HealthController {

    @GetMapping("/log")
    public HealthResponse health() {
        String a = "hello";
          log.info("포매팅 지원 확인 {}", a);  // INFO 레벨
//        log.info("헬스체크 요청");           // INFO 레벨
//        log.debug("상세 디버깅 정보");       // DEBUG 레벨
//        log.error("에러 발생");            // ERROR 레벨
        return new HealthResponse(
                "UP",
                LocalDateTime.now().toString()
        );
    }
}