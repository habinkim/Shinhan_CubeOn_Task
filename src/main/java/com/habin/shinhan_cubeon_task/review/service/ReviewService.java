package com.habin.shinhan_cubeon_task.review.service;

import com.habin.shinhan_cubeon_task.common.dto.ApiResponse;
import com.habin.shinhan_cubeon_task.review.dto.ReviewCreateDto;
import com.habin.shinhan_cubeon_task.review.dto.ReviewUpdateDto;
import com.habin.shinhan_cubeon_task.review.entity.Review;
import com.habin.shinhan_cubeon_task.review.mapper.ReviewMapper;
import com.habin.shinhan_cubeon_task.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.function.Supplier;

@Service
@Transactional
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final ReviewMapper reviewMapper;

    @Transactional(readOnly = true)
    public ApiResponse<?> list() {
        return null;
    }

    @Transactional
    public ResponseEntity<ApiResponse<Object>> create(ReviewCreateDto reviewCreateDto) {
        Review review = reviewMapper.createDtoToEntity(reviewCreateDto);
        reviewRepository.save(review);
        return ApiResponse.success();
    }

    @Transactional
    public ResponseEntity<ApiResponse<?>> update(ReviewUpdateDto reviewUpdateDto) {
        Review review = reviewRepository.findById(reviewUpdateDto.getReviewId())
                .orElseThrow(getNSEE.apply("리뷰 정보"));


        return null;
    }

    @Transactional
    public ResponseEntity<ApiResponse<Object>> delete(Long reviewId) {
        reviewRepository.deleteById(reviewId);
        return ApiResponse.success();
    }

    public static final Function<String, Supplier<NoSuchElementException>> getNSEE =
            (s) -> () -> new NoSuchElementException(s + "이(가) 존재하지 않습니다.");

}
