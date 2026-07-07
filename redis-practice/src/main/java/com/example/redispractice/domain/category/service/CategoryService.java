package com.example.redispractice.domain.category.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {

    public static final String CATEGORY_KEY = "category";
    private final StringRedisTemplate stringRedisTemplate;

    public String findCategoryInfo(String category) {
        // 외부 URL을 통해 받아온 category를 redis score 1을 올려줌 것
        // redis에 category라는 키 안, 외부에서 받아온 category value에 1점을 올려줄 것
        stringRedisTemplate.opsForZSet().incrementScore(CATEGORY_KEY, category, 1);
        return category + "을/를 조회 하였습니다.";
    }
}
