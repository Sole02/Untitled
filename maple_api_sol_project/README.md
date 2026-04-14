# 🍁 Maple API Sol Project

메이플스토리 캐릭터 정보를 조회하는 REST API 서버입니다.  
NEXON Open API를 활용하여 캐릭터 기본 정보를 제공합니다.

<br>

## 🛠 기술 스택

- Java 17
- Spring Boot 3.x
- Spring Web
- Lombok
- MySQL
- JPA

<br>

## 📌 구현 기능

- 캐릭터 닉네임으로 기본 정보 조회

<br>

## 📁 프로젝트 구조

```
src/main/java/com/example/maple_api_sol_project/
├── config/
│   └── MapleApiConfig.java
├── controller/
│   └── CharacterController.java
├── service/
│   └── CharacterService.java
└── dto/
    ├── CharacterOcidResponse.java
    └── CharacterBasicResponse.java
```

<br>

## ⚙️ 환경 설정

본 프로젝트는 보안을 위해 API Key를 환경 변수로 관리합니다.

- MAPLE_API_KEY: 넥슨 오픈 API 센터에서 발급받은 API 키

<br>

## 🚀 API 사용법

### 캐릭터 기본 정보 조회
```
GET /api/characters/{닉네임}
```

**응답 예시**
```json
{
  "characterName": "솔격",
  "characterLevel": 291,
  "characterClass": "패스파인더",
  "worldName": "크로아",
  "characterImage": "https://..."
}
```

<br>

## 👤 개발자

- GitHub: [@Sole02](https://github.com/Sol)
