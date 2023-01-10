package com.habin.shinhan_cubeon_task.review.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Builder(toBuilder = true)
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Lecture {

//    a. 강의 id: 1
//    b. 강의 제목: 스프링 부트와 JPA로 초간단 API 개발하기
//    c. 강사 이름: 신한큐브온
//    d. 난도: 초급
//    e. 수강기한: 무제한

    @Id
    @Column(length = 5)
    @Comment("강의 ID")
    private Integer lectureId;

    @Column(length = 30, nullable = false)
    @Comment("강의 제목")
    private String lectureName;

    @Column(length = 10, nullable = false)
    @Comment("강사 이름")
    private String teacher;

    @Column(length = 10, nullable = false)
    @Comment("난도")
    private String difficulty;

    @Column(length = 20, nullable = false)
    @Comment("수강기한")
    private String lecturePeriod;

}
