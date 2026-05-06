package com.example.backoffice.admin.controller;

import com.example.backoffice.admin.dto.request.AdminCreateRequestDto;
import com.example.backoffice.admin.dto.response.AdminCreateResponseDto;
import com.example.backoffice.admin.service.AdminService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admins")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }


    @PostMapping("/signup")
    public AdminCreateResponseDto adminSignup(@RequestBody AdminCreateRequestDto request) {
        return adminService.adminSignup(request);
    }
}
