package com.example.springfilterpractice.common.filter;

import com.example.springfilterpractice.common.utils.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@Slf4j
@RequiredArgsConstructor
@Order(3)
public class JwtFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        // 토큰을 발급 받는 로그인의 경우 토큰 확인 없이 통과
        String requestURL = request.getRequestURI();
        if(requestURL.equals("/api/user/login")) {
            filterChain.doFilter(request, response);
            return;
        }

        // 토큰 존재 확인
        String authorizationHeader = request.getHeader("Authorization");
        if(authorizationHeader == null || authorizationHeader.isBlank()) {
            log.info("JWT 토큰이 필요합니다.");
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "JWT 토큰이 필요합니다.");
            return;
        }

        // 토큰 유효 확인
        String jwt = authorizationHeader.substring(7);
        if(!jwtUtil.validateToken(jwt)) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.getWriter().write("{\"error\": \"Unauthorized\"}");
            return;
        }

        // 토큰 정보 확인
        String username = jwtUtil.extractUsername(jwt);
        request.setAttribute("username", username);
        filterChain.doFilter(request, response);

    }
}
