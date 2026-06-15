package com.example.chatservice.domain.controller;

import com.example.chatservice.common.uilts.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class JwtController {

    private final JwtUtil jwtUtil;

    @GetMapping("/api/jwt/{userId}")
    public String generateToken(@PathVariable Long userId) {
        return jwtUtil.generateToken(userId);
    }
}
