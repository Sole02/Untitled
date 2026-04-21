package com.example.schedule_v2.service;

import com.example.schedule_v2.dto.request.ScheduleCreateRequestDto;
import com.example.schedule_v2.dto.response.ScheduleCreateResponseDto;
import com.example.schedule_v2.dto.response.ScheduleReadResponseDto;
import com.example.schedule_v2.entity.Schedule;
import com.example.schedule_v2.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduleService {

    // 속성
    private final ScheduleRepository scheduleRepository;

    // 생성자
    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    // 기능
    public ScheduleCreateResponseDto createSchedule (ScheduleCreateRequestDto requestDto) {
        String foundTitle = requestDto.getTitle();
        String foundContent = requestDto.getContent();
        Schedule newSchedule = new Schedule(foundTitle, foundContent);
        Schedule savedSchedule = scheduleRepository.save(newSchedule);
        Long savedScheduleId = savedSchedule.getId();
        String savedScheduleTitle = savedSchedule.getTitle();
        String savedScheduleContent = savedSchedule.getContent();
        ScheduleCreateResponseDto result = new ScheduleCreateResponseDto(savedScheduleId, savedScheduleTitle, savedScheduleContent);
        return result;
    }
    // 다건 조회
    public List<ScheduleReadResponseDto> getAllSchedules() {
        // 전체 목록 조회하기
        List<Schedule> foundSchedulesList = scheduleRepository.findAll();
        // dto 리스트 만들기
        List<ScheduleReadResponseDto> scheduleDtoList = new ArrayList<>();
        // 루프 (꺼낼타입 변수명 : 목록) {}
        for (Schedule schedule : foundSchedulesList) {
            // 데이터 꺼내기
            Long id = schedule.getId();
            String title = schedule.getTitle();
            String content = schedule.getContent();
            // dto 만들기
            ScheduleReadResponseDto scheduleDto = new ScheduleReadResponseDto(id, title, content);
            // 리스트에 담기
            scheduleDtoList.add(scheduleDto);
        }
        // 반환
        return scheduleDtoList;
    }
}