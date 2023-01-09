package com.habin.shinhan_cubeon_task.review.repository;

import com.habin.shinhan_cubeon_task.review.dto.ReviewListDto;
import com.querydsl.core.types.Order;
import org.springframework.data.domain.Page;

public interface QReviewRepository {
    Page<ReviewListDto> list(Boolean recent, Order grade, Integer pageNo);
}
