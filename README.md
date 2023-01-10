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
  - `spring.jpa.database-platform`
  - `spring.jpa.hibernate.ddl-auto`



## 3. OAS - Swagger UI URL

- http://localhost:7200/swagger-ui.html



## 4. 초기 데이터 세팅

- 강의 데이터 1개 초기 생성
- 사용자 데이터 10개 초기 생성
  - `/user` (사용자 리스트 조회) API를 통해 아이디 확인 가능합니다.



## 5. GET `/review` 강의 리뷰 리스트 조회 API

- RequestParam

  - recent (최근 내림차순 정렬, 동적 파라미터) : true / false
  - grade (평점 정렬, 동적 파라미터) : DESC / ASC
  - pageNo (페이지 번호, 고정 파라미터) : 1부터 시작

- RepsonseBody 예시

  - ```json
    {
      "message": "SUCCESS",
      "body": {
        "content": [
          {
            "lectureName": "스프링 부트와 JPA로 초간단 API 개발하기",
            "reviewId": 47,
            "grade": 5,
            "favCount": 6,
            "content": "nice!!",
            "createdAt": "2023-01-10 15:59:10",
            "updatedAt": "2023-01-10 15:59:10",
            "userId": "0000000000000000000y",
            "nickname": "aaaaaaaabr"
          },
          {
            "lectureName": "스프링 부트와 JPA로 초간단 API 개발하기",
            "reviewId": 46,
            "grade": 5,
            "favCount": 6,
            "content": "nice!!",
            "createdAt": "2023-01-10 15:59:10",
            "updatedAt": "2023-01-10 15:59:10",
            "userId": "0000000000000000000y",
            "nickname": "aaaaaaaabr"
          },
          {
            "lectureName": "스프링 부트와 JPA로 초간단 API 개발하기",
            "reviewId": 45,
            "grade": 5,
            "favCount": 6,
            "content": "nice!!",
            "createdAt": "2023-01-10 15:59:10",
            "updatedAt": "2023-01-10 15:59:10",
            "userId": "0000000000000000000y",
            "nickname": "aaaaaaaabr"
          },
          {
            "lectureName": "스프링 부트와 JPA로 초간단 API 개발하기",
            "reviewId": 63,
            "grade": 4,
            "favCount": 3,
            "content": "nice!!",
            "createdAt": "2023-01-10 15:59:12",
            "updatedAt": "2023-01-10 15:59:12",
            "userId": "0000000000000000000y",
            "nickname": "aaaaaaaabr"
          },
          {
            "lectureName": "스프링 부트와 JPA로 초간단 API 개발하기",
            "reviewId": 66,
            "grade": 4,
            "favCount": 3,
            "content": "nice!!",
            "createdAt": "2023-01-10 15:59:12",
            "updatedAt": "2023-01-10 15:59:12",
            "userId": "0000000000000000000y",
            "nickname": "aaaaaaaabr"
          },
          {
            "lectureName": "스프링 부트와 JPA로 초간단 API 개발하기",
            "reviewId": 62,
            "grade": 4,
            "favCount": 3,
            "content": "nice!!",
            "createdAt": "2023-01-10 15:59:11",
            "updatedAt": "2023-01-10 15:59:11",
            "userId": "0000000000000000000y",
            "nickname": "aaaaaaaabr"
          },
          {
            "lectureName": "스프링 부트와 JPA로 초간단 API 개발하기",
            "reviewId": 69,
            "grade": 2,
            "favCount": 3,
            "content": "nice!!",
            "createdAt": "2023-01-10 15:59:12",
            "updatedAt": "2023-01-10 15:59:12",
            "userId": "0000000000000000000y",
            "nickname": "aaaaaaaabr"
          },
          {
            "lectureName": "스프링 부트와 JPA로 초간단 API 개발하기",
            "reviewId": 65,
            "grade": 4,
            "favCount": 3,
            "content": "nice!!",
            "createdAt": "2023-01-10 15:59:12",
            "updatedAt": "2023-01-10 15:59:12",
            "userId": "0000000000000000000y",
            "nickname": "aaaaaaaabr"
          },
          {
            "lectureName": "스프링 부트와 JPA로 초간단 API 개발하기",
            "reviewId": 61,
            "grade": 4,
            "favCount": 3,
            "content": "nice!!",
            "createdAt": "2023-01-10 15:59:11",
            "updatedAt": "2023-01-10 15:59:11",
            "userId": "0000000000000000000y",
            "nickname": "aaaaaaaabr"
          },
          {
            "lectureName": "스프링 부트와 JPA로 초간단 API 개발하기",
            "reviewId": 68,
            "grade": 2,
            "favCount": 3,
            "content": "nice!!",
            "createdAt": "2023-01-10 15:59:12",
            "updatedAt": "2023-01-10 15:59:12",
            "userId": "0000000000000000000y",
            "nickname": "aaaaaaaabr"
          }
        ],
        "pageable": {
          "sort": {
            "empty": true,
            "unsorted": true,
            "sorted": false
          },
          "offset": 0,
          "pageNumber": 0,
          "pageSize": 10,
          "paged": true,
          "unpaged": false
        },
        "last": false,
        "totalPages": 8,
        "totalElements": 75,
        "first": true,
        "size": 10,
        "number": 0,
        "sort": {
          "empty": true,
          "unsorted": true,
          "sorted": false
        },
        "numberOfElements": 10,
        "empty": false
      }
    }
    ```

    