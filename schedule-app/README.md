# Project 일정관리 앱 Develop

머시깽이한 설명

## 기술 스택
- Java 17
- Spring boot
- MySQL
- JPA
- WEB

## 구현 기능
- 일정 등록
- 일정 조회
- 일정 수정
- 일정 삭제

## API 명세
| Method | URL | 설명 |
| POST | /schedule | 일정 등록 |
| GET | /schedule | 전체 조회 |
| GET | /schedule/{Id} | 단건 조회 |
| PUT | /schedule/{Id} | 일정 수정 |
| DELETE | /schedule/{Id} | 일정 삭제 |
