package com.habin.shinhan_cubeon_task.review.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.habin.shinhan_cubeon_task.common.json.CustomLocalDateTimeSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder(toBuilder = true)
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewListDto {

    private String lectureName;
    private Long reviewId;
    private Integer grade;
    private Integer favCount;
    private String content;

    @JsonSerialize(using = CustomLocalDateTimeSerializer.class)
    private LocalDateTime createdAt;

    @JsonSerialize(using = CustomLocalDateTimeSerializer.class)
    private LocalDateTime updatedAt;

    private String userId;
    private String nickname;

}
