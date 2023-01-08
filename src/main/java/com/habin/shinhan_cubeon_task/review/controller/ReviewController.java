package com.habin.shinhan_cubeon_task.review.controller;

import com.habin.shinhan_cubeon_task.common.dto.ApiResponse;
import com.habin.shinhan_cubeon_task.review.dto.ReviewCreateDto;
import com.habin.shinhan_cubeon_task.review.dto.ReviewUpdateDto;
import com.habin.shinhan_cubeon_task.review.service.ReviewService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping
    public ApiResponse<?> list() {
        return reviewService.list();
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Object>> create(@Valid @RequestBody ReviewCreateDto reviewCreateDto) {
        return reviewService.create(reviewCreateDto);
    }

    @PutMapping
    public ResponseEntity<ApiResponse<?>> update(@Valid @RequestBody ReviewUpdateDto reviewUpdateDto) {
        return reviewService.update(reviewUpdateDto);
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<ApiResponse<Object>> delete(@Valid @PathVariable Long reviewId) {
        return reviewService.delete(reviewId);
    }


}
