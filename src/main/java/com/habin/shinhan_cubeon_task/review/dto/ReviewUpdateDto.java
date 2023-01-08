package com.habin.shinhan_cubeon_task.review.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

@Builder(toBuilder = true)
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewUpdateDto {

    @NotNull(message = "리뷰 ID를 입력하지 않으셨습니다.")
    private Long reviewId;

    @Range(min = 1, max = 5, message = "리뷰 평점은 1점에서 5점으로 입력해주세요.")
    private Integer grade;

    @Size(max = 1000, message = "리뷰 본문은 1000자 이내로 입력해주세요.")
    private String content;

}
