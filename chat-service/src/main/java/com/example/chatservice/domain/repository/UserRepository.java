package com.example.chatservice.domain.repository;

import com.example.chatservice.common.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
