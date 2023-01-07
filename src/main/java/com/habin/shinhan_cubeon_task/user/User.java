package com.habin.shinhan_cubeon_task.user;

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
public class User {

    @Id
    @Column(length = 20)
    @Comment("사용자 ID")
    private String userId;

    @Column(nullable = false, length = 10)
    @Comment("사용자 닉네임")
    private String nickname;

    @Column(length = 50)
    @Comment("사용자 프로필 썸네일 URL")
    private String profileThumbnailUrl;

}
