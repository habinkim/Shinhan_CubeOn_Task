package com.habin.shinhan_cubeon_task.review.controller;

import com.habin.shinhan_cubeon_task.common.dto.ApiResponse;
import com.habin.shinhan_cubeon_task.review.dto.ReviewCreateDto;
import com.habin.shinhan_cubeon_task.review.dto.ReviewListDto;
import com.habin.shinhan_cubeon_task.review.dto.ReviewUpdateDto;
import com.habin.shinhan_cubeon_task.review.service.ReviewService;
import com.querydsl.core.types.Order;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "강의 리뷰 관리 - /review", description = "강의 리뷰 정보 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService reviewService;

    @Tag(name = "강의 리뷰 관리 - /review", description = "강의 리뷰 정보 API")
    @Operation(summary = "강의 리뷰 리스트 조회", description = "강의 리뷰 리스트 조회 API")
    @GetMapping
    public ResponseEntity<ApiResponse<Page<ReviewListDto>>> list(@RequestParam(name = "recent", required = false) Boolean recent,
                                                                 @RequestParam(name = "grade", required = false) Order grade,
                                                                 @RequestParam(name = "pageNo") Integer pageNo) {
        return reviewService.list(recent, grade, pageNo);
    }

    @Tag(name = "강의 리뷰 관리 - /review", description = "강의 리뷰 정보 API")
    @Operation(summary = "강의 리뷰 생성", description = "강의 리뷰 생성 API")
    @PostMapping
    public ResponseEntity<ApiResponse<Object>> create(@Valid @RequestBody ReviewCreateDto reviewCreateDto) {
        return reviewService.create(reviewCreateDto);
    }

    @Tag(name = "강의 리뷰 관리 - /review", description = "강의 리뷰 정보 API")
    @Operation(summary = "강의 리뷰 수정", description = "강의 리뷰 수정 API")
    @PutMapping
    public ResponseEntity<ApiResponse<Object>> update(@Valid @RequestBody ReviewUpdateDto reviewUpdateDto) {
        return reviewService.update(reviewUpdateDto);
    }

    @Tag(name = "강의 리뷰 관리 - /review", description = "강의 리뷰 정보 API")
    @Operation(summary = "강의 리뷰 삭제", description = "강의 리뷰 삭제 API")
    @DeleteMapping("/{reviewId}")
    public ResponseEntity<ApiResponse<Object>> delete(@PathVariable Long reviewId) {
        return reviewService.delete(reviewId);
    }

}
