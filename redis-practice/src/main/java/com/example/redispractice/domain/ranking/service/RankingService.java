package com.example.redispractice.domain.ranking.service;

import com.example.redispractice.domain.ranking.model.RankingDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations.TypedTuple;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import static com.example.redispractice.domain.category.service.CategoryService.CATEGORY_DAILY_KEY;
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

    // standardDate 기준으로 3일치 zest을 가져올 예정 -> 선별된 zest
    // 선별된 zset을 하나의  zset을 묶어 상위 몇 개 하위 몇 개 원하는 조건대로 조회
    public List<RankingDto> findTop3CategoryInLast3Days(LocalDate standardDate) {

        // 최근 3일간 데이터를 가져오기 위한 키 값
        List<String> keys = List.of(
                CATEGORY_DAILY_KEY + standardDate.toString().isBlank(),
                CATEGORY_DAILY_KEY + standardDate.minusDays(1).toString(),
                CATEGORY_DAILY_KEY + standardDate.minusDays(2).toString()
        );

        // 결과가 저장 될 임시 key
        String destKey = "category_rank:last3Days:";

        // 결과 합
        stringRedisTemplate.opsForZSet().unionAndStore(
                keys.get(0), // 중심이 되는 zset의 이름
                keys.subList(1, keys.size()), // 중심이 되는 zset을 제외한 나머지 것들
                destKey // 어떤 key에 값을 저장 할 것인지
        );

        return Collections.emptyList();
    }
}
