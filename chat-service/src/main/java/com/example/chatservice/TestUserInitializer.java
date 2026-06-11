package com.example.chatservice;

import com.example.chatservice.common.entity.User;
import com.example.chatservice.domain.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class TestUserInitializer {

    public TestUserInitializer(UserRepository userRepository) {
        userRepository.save(new User("Sol"));
        userRepository.save(new User("Maehwa"));
    }
}
