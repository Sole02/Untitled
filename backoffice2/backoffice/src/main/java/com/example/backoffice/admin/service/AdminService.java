package com.example.backoffice.admin.service;

import com.example.backoffice.admin.dto.request.AdminCreateRequestDto;
import com.example.backoffice.admin.dto.response.AdminCreateResponseDto;
import com.example.backoffice.admin.entity.Admin;
import com.example.backoffice.admin.repository.AdminRepository;
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
    public AdminCreateResponseDto adminSignup(AdminCreateRequestDto request) {
        // 1. 데이터 꺼내기
        String foundName = request.getName();
        // 2. 엔티티 생성
        Admin entityAdmin = new Admin(foundName);
        // 3. DB 저장 후 4. 반환
        Admin savedAdmin = adminRepository.save(entityAdmin);
        // 5. 값 꺼내기
        Long savedId = savedAdmin.getId();
        String savedName = savedAdmin.getName();
        // 6. 응답 dto 만든 후
        AdminCreateResponseDto response = new AdminCreateResponseDto(savedId, savedName);
        // 7. 반환
        return response;
    }
}
