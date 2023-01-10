# 신한 큐브온 과제전형

[TOC]

------



## 1. 주요 사용 기술, 의존성

- JDK : OpenJDK 17
- Spring Boot : 3.0.1
- DataBase : MariaDB 10.6 (local)
- 데이터 접근 기술 : JPA, Spring Data JPA, QueryDSL
- OAS Generator : springdoc-openapi-starter-webmvc-ui
- Entity, Dto Mapper : MapStruct
- Test Case Data Generator : Naver Fixture Monkey



## 2. JDBC Connection 설정

- 로컬로 실행하시려면 `src/main/resources/application.yml` 파일의 일부 property 수정이 필요합니다
  - `spring.datasource.url`
  - `spring.datasource.username`
  - `spring.datasource.password`
  - `spring.datasource.driver-class-name`