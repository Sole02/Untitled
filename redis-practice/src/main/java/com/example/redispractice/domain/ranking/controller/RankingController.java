package com.example.redispractice.domain.ranking.controller;

import com.example.redispractice.domain.ranking.model.RankingDto;
import com.example.redispractice.domain.ranking.service.RankingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/ranking")
@RequiredArgsConstructor
public class RankingController {

    private final RankingService rankingService;

    @GetMapping("/category")
    public ResponseEntity<List<RankingDto>> findCategoryTopN(@RequestParam(defaultValue = "3") int limit) {
        return ResponseEntity.ok(rankingService.findCategoryTOPN(limit));
    }
}
