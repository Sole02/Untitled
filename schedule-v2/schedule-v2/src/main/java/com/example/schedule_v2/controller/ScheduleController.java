package com.example.schedule_v2.controller;

import com.example.schedule_v2.dto.request.ScheduleCreateRequestDto;
import com.example.schedule_v2.dto.request.ScheduleUpdateRequestDto;
import com.example.schedule_v2.dto.response.ScheduleCreateResponseDto;
import com.example.schedule_v2.dto.response.ScheduleReadResponseDto;
import com.example.schedule_v2.dto.response.ScheduleUpdateResponseDto;
import com.example.schedule_v2.service.ScheduleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
    public ScheduleCreateResponseDto createSchedule(@RequestBody ScheduleCreateRequestDto requestDto) {
        return scheduleService.createSchedule(requestDto);
    }

    // 다건 일정 조회
    @GetMapping
    public List<ScheduleReadResponseDto> getAllSchedules() {
        return scheduleService.getAllSchedules();
    }

    // 단건 일정 조회
    @GetMapping("/{id}")
    public ScheduleReadResponseDto getSchedule(@PathVariable Long id) {
        return scheduleService.getSchedule(id);
    }

    // 일정 수정
    @PutMapping("/{id}")
    public ScheduleUpdateResponseDto updateSchedule(@PathVariable Long id, @RequestBody ScheduleUpdateRequestDto requestDto) {

    }
}