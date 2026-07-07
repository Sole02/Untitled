package com.example.redispractice.domain.category.controller;

import com.example.redispractice.domain.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/{category}")
    public ResponseEntity<String> findCategoryInfo(@PathVariable String category) {
        // 카테고리 정보를 조회한 {카테고리}의 뷰 카운트를 올려줄 것
        // redis에 저장할 예정
        // TV -> /api/category/TV
        // Redis에 TV라는 zset 점수를 1 올려줌
        return ResponseEntity.ok(categoryService.findCategoryInfo(category));
    }
}
