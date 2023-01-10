package com.habin.shinhan_cubeon_task.review.service;

import com.habin.shinhan_cubeon_task.common.dto.ApiResponse;
import com.habin.shinhan_cubeon_task.review.dto.ReviewCreateDto;
import com.habin.shinhan_cubeon_task.review.dto.ReviewListDto;
import com.habin.shinhan_cubeon_task.review.dto.ReviewUpdateDto;
import com.habin.shinhan_cubeon_task.review.entity.Review;
import com.habin.shinhan_cubeon_task.review.mapper.ReviewMapper;
import com.habin.shinhan_cubeon_task.review.repository.LectureRepository;
import com.habin.shinhan_cubeon_task.review.repository.ReviewRepository;
import com.querydsl.core.types.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
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
    private final LectureRepository lectureRepository;
    private final ReviewMapper reviewMapper;

    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse<Page<ReviewListDto>>> list(Boolean recent, Order grade, Integer pageNo) {
        Page<ReviewListDto> list = reviewRepository.list(recent, grade, pageNo);
        return ApiResponse.success(list);
    }

    @Transactional
    public ResponseEntity<ApiResponse<Object>> create(ReviewCreateDto reviewCreateDto) {
        Review review = reviewMapper.createDtoToEntity(reviewCreateDto);
        reviewRepository.save(review);
        return ApiResponse.success();
    }

    @Transactional
    public ResponseEntity<ApiResponse<Object>> update(ReviewUpdateDto reviewUpdateDto) {
        Review review = reviewRepository.findById(reviewUpdateDto.getReviewId())
                .orElseThrow(getNSEE.apply("리뷰 정보"));

        review = reviewMapper.updateDtoToEntity(reviewUpdateDto, review.toBuilder()).build();
        reviewRepository.save(review);

        return ApiResponse.success();
    }

    @Transactional
    public ResponseEntity<ApiResponse<Object>> delete(Long reviewId) {
        reviewRepository.deleteById(reviewId);
        return ApiResponse.success();
    }

    public static final Function<String, Supplier<NoSuchElementException>> getNSEE =
            (s) -> () -> new NoSuchElementException(s + "이(가) 존재하지 않습니다.");

}
