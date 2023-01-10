package com.habin.shinhan_cubeon_task.fav.entity;

import com.habin.shinhan_cubeon_task.review.entity.Review;
import com.habin.shinhan_cubeon_task.user.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import static jakarta.persistence.FetchType.LAZY;

@Builder(toBuilder = true)
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Fav {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 30)
    @Comment("좋아요 ID")
    private Long favId;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(nullable = false, name = "userId", referencedColumnName = "userId")
    @Comment("사용자 ID")
    private User user;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(nullable = false, name = "reviewId", referencedColumnName = "reviewId")
    @Comment("리뷰 ID")
    private Review review;

}
