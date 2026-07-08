package com.example.kafka.domain.errorDemo.controller;

import com.example.kafka.domain.errorDemo.producer.ErrorDemoProducer;
import com.example.kafka.domain.simple.model.request.SimpleSendRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/error-demo")
@RequiredArgsConstructor
public class ErrorDemoController {

    private final ErrorDemoProducer errorDemoProducer;

    @PostMapping
    public ResponseEntity<Void> sendErrorDemoMessage(@RequestBody SimpleSendRequest request) {
        errorDemoProducer.send(request.getMessage());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
