package com.example.redispractice.domain.ranking.service;

import com.example.redispractice.domain.ranking.model.RankingDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations.TypedTuple;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import static com.example.redispractice.domain.category.service.CategoryService.CATEGORY_KEY;

@Service
@RequiredArgsConstructor
public class RankingService {

    private final StringRedisTemplate stringRedisTemplate;

    // redis에서 직접 값을 가져오는 메서드
    public List<RankingDto> findCategoryTOPN(int limit) {

        // 1 단계 : redis에서 category 안에 있는 값을, 상위 몇 개만 가져올 것
        Set<TypedTuple<String>> result = stringRedisTemplate.opsForZSet()
                .reverseRangeWithScores(CATEGORY_KEY, 0, limit - 1);

        if (result == null) {
            return Collections.emptyList();
        }

        return result.stream()
                .map(tuple -> new RankingDto(tuple.getValue(), tuple.getScore()))
                .toList();
    }
}
