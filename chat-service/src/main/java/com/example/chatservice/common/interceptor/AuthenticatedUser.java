package com.example.chatservice.common.interceptor;

import com.example.chatservice.common.entity.User;
import lombok.Getter;

import java.security.Principal;

@Getter
public class AuthenticatedUser implements Principal {

    private final User user;
    private final String name;

    public AuthenticatedUser(User user) {
        this.user = user;
        this.name = user.getName();
    }

    // Principal에서 User 꺼내기
    public static User fromPrincipal(Principal principal) {
        return ((AuthenticatedUser) principal).getUser();
    }
}