package com.example.schedule_v2.service;

import com.example.schedule_v2.dto.request.ScheduleCreateRequestDto;
import com.example.schedule_v2.dto.request.ScheduleUpdateRequestDto;
import com.example.schedule_v2.dto.response.ScheduleCreateResponseDto;
import com.example.schedule_v2.dto.response.ScheduleReadResponseDto;
import com.example.schedule_v2.dto.response.ScheduleUpdateResponseDto;
import com.example.schedule_v2.entity.Schedule;
import com.example.schedule_v2.repository.ScheduleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScheduleService {

    // 속성
    private final ScheduleRepository scheduleRepository;

    // 생성자
    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    // 기능
    // 생성
    @Transactional
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
    @Transactional(readOnly = true)
    public List<ScheduleReadResponseDto> getAllSchedules() {
        // stream 방식
        List<ScheduleReadResponseDto> scheduleDtoList = scheduleRepository.findAll().stream()
                .map(schedule -> new ScheduleReadResponseDto(schedule.getId(), schedule.getTitle(), schedule.getContent()))
                .collect(Collectors.toList());
        return scheduleDtoList;
//        // 전체 목록 조회하기
//        List<Schedule> foundSchedulesList = scheduleRepository.findAll();
//        // dto 리스트 만들기
//        List<ScheduleReadResponseDto> scheduleDtoList = new ArrayList<>();
//        // for 루프 (꺼낼타입 변수명 : 목록) {}
//        for (Schedule schedule : foundSchedulesList) {
//            // 데이터 꺼내기
//            Long id = schedule.getId();
//            String title = schedule.getTitle();
//            String content = schedule.getContent();
//            // dto 만들기
//            ScheduleReadResponseDto scheduleDto = new ScheduleReadResponseDto(id, title, content);
//            // 리스트에 담기
//            scheduleDtoList.add(scheduleDto);
//        }
//        // 반환
//        return scheduleDtoList;
    }
    // 단건 조회
    @Transactional(readOnly = true)
    public ScheduleReadResponseDto getSchedule(Long id) {
        // id로 DB에서 단건 조회
        Schedule foundSchedule = scheduleRepository.findById(id).orElseThrow();
        // 데이터 꺼내기
        Long foundId = foundSchedule.getId();
        String foundTitle = foundSchedule.getTitle();
        String foundContent = foundSchedule.getContent();
        // ResponseDto 만들기
        ScheduleReadResponseDto scheduleDto = new ScheduleReadResponseDto(foundId, foundTitle, foundContent);
        // 반환
        return scheduleDto;
    }
    // 수정
    @Transactional
    public ScheduleUpdateResponseDto updateSchedule(Long id, ScheduleUpdateRequestDto requestDto) {
        // 수정할 id값 조회
        Schedule foundSchedule = scheduleRepository.findById(id).orElseThrow();
        // 수정 데이터 준비
        Long foundId = foundSchedule.getId();
        String foundTitle = requestDto.getTitle();
        String foundContent = requestDto.getContent();
        // 수정 & 수정된 객체 반환
        Schedule updateSchedule = foundSchedule.update(foundTitle, foundContent);
        // 데이터 준비
        Long updatedId = updateSchedule.getId();
        String updatedTitle = updateSchedule.getTitle();
        String updatedContent = updateSchedule.getContent();
        // 응답 Dto 만들기
        ScheduleUpdateResponseDto responseDto = new ScheduleUpdateResponseDto(updatedId, updatedTitle, updatedContent);
        // 반환
        return responseDto;
    }
}