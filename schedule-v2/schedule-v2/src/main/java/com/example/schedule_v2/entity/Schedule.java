package com.example.schedule_v2.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

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

    // 수정 기능
    public Schedule update(String title, String content) {
        this.title = title;
        this.content = content;
        return this;
    }
}
