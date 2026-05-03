package com.example.backoffice.Admin.repository;

import com.example.backoffice.Admin.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
