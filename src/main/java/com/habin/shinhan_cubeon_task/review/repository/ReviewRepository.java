package com.habin.shinhan_cubeon_task.review.repository;

import com.habin.shinhan_cubeon_task.review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long>, QReviewRepository {

}
