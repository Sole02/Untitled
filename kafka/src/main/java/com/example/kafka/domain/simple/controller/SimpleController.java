package com.example.kafka.domain.simple.controller;

import com.example.kafka.domain.simple.model.request.SimpleSendRequest;
import com.example.kafka.domain.simple.producer.SimpleMessageProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/simple")
@RequiredArgsConstructor
public class SimpleController {

    private final SimpleMessageProducer simpleMessageProducer;

    @PostMapping
    public ResponseEntity<Void> sendSimpleMessage(@RequestBody SimpleSendRequest request) {
        simpleMessageProducer.send(request.getMessage());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
