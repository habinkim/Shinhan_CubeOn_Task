package com.habin.shinhan_cubeon_task.review.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder(toBuilder = true)
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDeleteDto {

    @NotEmpty(message = "리뷰 ID를 입력하지 않으셨습니다.")
    @NotNull(message = "리뷰 ID를 입력하지 않으셨습니다.")
    private List<Long> reviewIds;

}
