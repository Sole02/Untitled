package com.example.schedule_v2.service;

import com.example.schedule_v2.dto.request.ScheduleCreateRequestDto;
import com.example.schedule_v2.dto.response.ScheduleCreateResponseDto;
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

    public List<ScheduleCreateResponseDto> getAllSchedules(){
        List<Schedule> schedules = scheduleRepository.findAll();
        List<ScheduleCreateResponseDto> result = new ArrayList<>();
        for (Schedule schedule : schedules) {
            result.add(new ScheduleCreateResponseDto(
                    schedule.getId(),
                    schedule.getTitle(),
                    schedule.getContent()
            ));
        } return result;
    }
}
