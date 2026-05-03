package com.example.backoffice.Admin.service;

import com.example.backoffice.Admin.dto.request.AdminCreateRequestDto;
import com.example.backoffice.Admin.dto.response.AdminCreateResponseDto;
import com.example.backoffice.Admin.entity.Admin;
import com.example.backoffice.Admin.repository.AdminRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdminService {
    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    // 회원가입
    @Transactional
    public AdminCreateResponseDto signupAdmin(AdminCreateRequestDto requestDto) {
        Admin admin = new Admin(requestDto.getName());
        Admin savedAdmin = adminRepository.save(admin);
        return new AdminCreateResponseDto(
                savedAdmin.getId(),
                savedAdmin.getName()
        );
    }
}
