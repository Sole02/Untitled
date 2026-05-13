package com.example.rds.service;

import com.example.rds.entity.User;
import com.example.rds.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public void save() {
        User user = new User(
                UUID.randomUUID().toString()
        );
        userRepository.save(user);
    }
}