package com.example.redispractice.domain.category.controller;

import com.example.redispractice.domain.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

//    @GetMapping("/{category}")
//    public ResponseEntity<String> findCategoryInfo(@PathVariable String category) {
//        // 카테고리 정보를 조회한 {카테고리}의 뷰 카운트를 올려줄 것
//        // redis에 저장할 예정
//        // TV -> /api/category/TV
//        // Redis에 TV라는 zset 점수를 1 올려줌
//        return ResponseEntity.ok(categoryService.findCategoryInfo(category));
//    }

    // Time window 개념을 도입해서 시간, 날짜 별로 구분하여 값을 넣어줄 것
    // 2025-11-25
    // 2025-11-26
    // 2025-11-27 -> 오늘이라고 가정
    @GetMapping("/{category}")
    public ResponseEntity<String> findCategoryInfo(@PathVariable String category, @RequestParam LocalDate currentDate) {
        return ResponseEntity.ok(categoryService.findCategoryInfo(category, currentDate));
    }
}
