# Sakak Food Nutrition API

이 프로젝트는 식품 영양 데이터에 대한 CRUD 및 검색 기능을 제공하는 Spring Boot 기반 RESTful API입니다.  
Docker를 활용한 배포를 지원하며, 데이터베이스는 MySQL을 사용합니다.

## 기능

- 식품 데이터 등록, 조회, 수정, 삭제 (CRUD)
- 식품 이름, 코드, 제조사, 조사연도 기반 검색 (Paging 포함)
- SpringDoc 기반 Swagger UI 제공
- Liquibase를 통한 DB 초기 스키마/데이터 자동 적용

---

## 기술 스택

- Java 17
- Spring Boot 3.5.0
- Spring Data JPA + QueryDSL
- Liquibase
- MySQL 8.0
- Docker, Docker Compose
- Gradle

---

## 실행 방법 (Docker Compose)

### 1. 프로젝트 클론

```bash
git clone https://github.com/hobit22/codingtest.git
cd codingtest
```

### 2. 애플리케이션 Docker 이미지 빌드

```bash
docker build -t sakak-app .
```

### 3. Docker Compose 실행

```bash
docker-compose up
```
- `mysql` 컨테이너 → `sakak` 데이터베이스 자동 생성
- Liquibase → `schema` 및 `data.sql` 자동 적용
- 애플리케이션 → 포트 `8080`에서 실행

### 4. Swagger 접속

```
http://localhost:8080/swagger-ui/index.html
```

---

## API 문서

| 메서드 | 엔드포인트             | 설명                  |
|--------|------------------------|-----------------------|
| GET    | `/api/foods`           | 전체 식품 조회 (검색 포함) |
| POST   | `/api/foods`           | 식품 데이터 등록       |
| GET    | `/api/foods/{id}`      | 식품 상세 조회         |
| PUT    | `/api/foods/{id}`      | 식품 데이터 수정       |
| DELETE | `/api/foods/{id}`      | 식품 삭제             |

---

## 파일 구조

```text
.
├── docker-compose.yml
├── Dockerfile
├── build.gradle
└── src/main/java/team/sakak/codingtest
    ├── controller
    ├── dto
    ├── entity
    ├── repository
    ├── service
    └── SakakApplication.java
```

---

## 참고 사항

- DB 접속 정보는 `application.yml`과 `docker-compose.yml`의 환경변수를 통해 설정됩니다.

---
