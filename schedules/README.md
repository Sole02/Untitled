# 🗓️ 일정 관리 앱 (Schedule Management App)

Spring Boot와 JPA를 이용한 일정 관리 API 서버입니다.

## 🛠️ 기술 스택
- **Language:** Java 17
- **Framework:** Spring Boot 3.x
- **Database:** MySQL
- **ORM:** Spring Data JPA

---

## 📊 ERD (Database Modeling)

우리는 하나의 테이블(`schedules`)을 사용하여 일정을 관리합니다.

| 컬럼명 | 타입 | 설명 | 비고 |
| :--- | :--- | :--- | :--- |
| **id** | Long | 일정 식별자 | PK, Auto Increment |
| **title** | String | 일정 제목 | Not Null |
| **content** | String | 일정 내용 | |
| **name** | String | 담당자 이름 | |
| **password** | String | 비밀번호 | 수정/삭제 권한 확인용 |
| **created_at** | LocalDateTime | 생성일 | |
| **modified_at** | LocalDateTime | 수정일 | |

### ERD Diagram
```mermaid
erDiagram
    SCHEDULES {
        long id PK
        string title
        string content
        string name
        string password
        datetime created_at
        datetime modified_at
    }