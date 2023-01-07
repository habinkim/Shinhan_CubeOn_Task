package com.habin.shinhan_cubeon_task.review.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class QReviewRepositoryImpl implements QReviewRepository {

    private final JPAQueryFactory queryFactory;

}
