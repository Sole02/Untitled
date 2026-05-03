package com.example.backoffice.Admin.controller;

import com.example.backoffice.Admin.dto.request.AdminCreateRequestDto;
import com.example.backoffice.Admin.dto.response.AdminCreateResponseDto;
import com.example.backoffice.Admin.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;


    // 회원가입
    @PostMapping("/admins/signup")
    public ResponseEntity<AdminCreateResponseDto> signupAdmin(@RequestBody AdminCreateRequestDto request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(adminService.signupAdmin(request));
    }
}
