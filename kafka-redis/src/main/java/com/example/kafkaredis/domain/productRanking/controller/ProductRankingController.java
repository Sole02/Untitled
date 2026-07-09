package com.example.kafkaredis.domain.productRanking.controller;

import com.example.kafkaredis.common.model.redis.RankingDto;
import com.example.kafkaredis.domain.productRanking.service.ProductRankingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/ranking/product")
public class ProductRankingController {

    private final ProductRankingService productRankingService;

    @GetMapping("/today")
    public ResponseEntity<List<RankingDto>> findProductRankingTop3InToday() {
        return ResponseEntity.ok(productRankingService.findProductRankingTop3InToday());
    }
}
