package com.habin.shinhan_cubeon_task.review.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.habin.shinhan_cubeon_task.common.json.CustomLocalDateTimeDeserializer;
import com.habin.shinhan_cubeon_task.common.json.CustomLocalDateTimeSerializer;
import com.habin.shinhan_cubeon_task.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;

@EntityListeners(AuditingEntityListener.class)
@Builder(toBuilder = true)
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Review {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(length = 30)
    @Comment("리뷰 Id")
    private Long reviewId;

    @Column(nullable = false, length = 1)
    @Comment("리뷰 평점")
    private Integer grade;

    @Column(nullable = false, length = 3)
    @Comment("리뷰 좋아요 개수")
    private Integer likeCount;

    @Column(nullable = false, length = 1000)
    @Comment("리뷰 본문")
    private String content;

    @CreatedDate
    @JsonDeserialize(using = CustomLocalDateTimeDeserializer.class)
    @JsonSerialize(using = CustomLocalDateTimeSerializer.class)
    @Column(updatable = false)
    @Comment("리뷰 등록 일시")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @JsonDeserialize(using = CustomLocalDateTimeDeserializer.class)
    @JsonSerialize(using = CustomLocalDateTimeSerializer.class)
    @Column
    @Comment("리뷰 수정 일시")
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;

}
