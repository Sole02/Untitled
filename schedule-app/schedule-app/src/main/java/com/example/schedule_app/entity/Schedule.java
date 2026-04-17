package com.example.schedule_app.entity;

import jakarta.persistence.*;

@Entity
@Table (name = "schedules")
public class Schedule {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    // 속성
    private Long id;
    private String title;
    private String content;

    // 생성자
    public Schedule() {}

    public Schedule(String title, String content) {
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
