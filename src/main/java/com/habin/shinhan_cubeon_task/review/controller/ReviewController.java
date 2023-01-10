package com.habin.shinhan_cubeon_task.review.controller;

import com.habin.shinhan_cubeon_task.common.dto.ApiResponse;
import com.habin.shinhan_cubeon_task.review.dto.ReviewCreateDto;
import com.habin.shinhan_cubeon_task.review.dto.ReviewListDto;
import com.habin.shinhan_cubeon_task.review.dto.ReviewUpdateDto;
import com.habin.shinhan_cubeon_task.review.service.ReviewService;
import com.querydsl.core.types.Order;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping
    public ResponseEntity<ApiResponse<Page<ReviewListDto>>> list(@RequestParam Boolean recent,
                                                                 @RequestParam Order grade,
                                                                 @RequestParam Integer pageNo) {
        return reviewService.list(recent, grade, pageNo);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Object>> create(@Valid @RequestBody ReviewCreateDto reviewCreateDto) {
        return reviewService.create(reviewCreateDto);
    }

    @PutMapping
    public ResponseEntity<ApiResponse<Object>> update(@Valid @RequestBody ReviewUpdateDto reviewUpdateDto) {
        return reviewService.update(reviewUpdateDto);
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<ApiResponse<Object>> delete(@PathVariable Long reviewId) {
        return reviewService.delete(reviewId);
    }

}
