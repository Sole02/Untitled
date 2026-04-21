package com.example.schedule_v2.dto.response;

public class ScheduleReadResponseDto {
    // 속성
    private Long id;
    private String title;
    private String content;

    // 생성자
    public ScheduleReadResponseDto(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    // 기능
    public Long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getContent() {
        return content;
    }
}
