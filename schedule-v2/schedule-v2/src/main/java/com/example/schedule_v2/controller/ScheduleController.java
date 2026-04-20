package com.example.schedule_v2.controller;

import com.example.schedule_v2.dto.request.ScheduleCreateRequestDto;
import com.example.schedule_v2.dto.response.ScheduleCreateResponseDto;
import com.example.schedule_v2.service.ScheduleService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {
    // 속성
    private final ScheduleService scheduleService;

    // 생성자
    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    // 기능

    // 일정 생성
    @PostMapping
    public ScheduleCreateResponseDto createSchedule (@RequestBody ScheduleCreateRequestDto requestDto) {
        return scheduleService.createSchedule(requestDto);
    }
}
