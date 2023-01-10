package com.habin.shinhan_cubeon_task.review.repository;

import com.habin.shinhan_cubeon_task.review.dto.ReviewListDto;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.support.PageableExecutionUtils;

import java.util.List;

import static com.habin.shinhan_cubeon_task.review.entity.QLecture.lecture;
import static com.habin.shinhan_cubeon_task.review.entity.QReview.review;
import static com.habin.shinhan_cubeon_task.user.entity.QUser.user;
import static com.querydsl.core.types.Projections.fields;

@RequiredArgsConstructor
public class QReviewRepositoryImpl implements QReviewRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public Page<ReviewListDto> list(Boolean recent, Order grade, Integer pageNo) {
        PageRequest pageRequest = PageRequest.of(pageNo - 1, 10);
        OrderSpecifier<?>[] orderSpecifiers = getOrderSpecifier(recent, grade);

        List<ReviewListDto> fetch = queryFactory.select(fields(ReviewListDto.class,
                        lecture.lectureName,
                        review.reviewId,
                        review.grade,
                        review.favCount,
                        review.content,
                        review.createdAt,
                        review.updatedAt,
                        user.userId,
                        user.nickname
                ))
                .from(review)
                .join(review.lecture, lecture)
                .join(review.user, user)
                .offset(pageRequest.getOffset())
                .limit(pageRequest.getPageSize())
                .orderBy(orderSpecifiers)
                .fetch();

        JPAQuery<Long> countQuery = queryFactory.select(review.reviewId.count())
                .from(review)
                .join(review.lecture, lecture);

        return PageableExecutionUtils.getPage(fetch, pageRequest, countQuery::fetchOne);
    }

    private OrderSpecifier<?>[] getOrderSpecifier(Boolean recent, Order grade) {
        OrderSpecifier<?>[] orderSpecifiers = new OrderSpecifier[3];
        orderSpecifiers[0] = review.favCount.desc();

        if (recent) {
            orderSpecifiers[1] = review.createdAt.desc();
        }

        switch (grade) {
            case ASC -> {
                orderSpecifiers[2] = review.grade.asc();
            }
            case DESC -> {
                orderSpecifiers[2] = review.grade.desc();
            }
        }

        return orderSpecifiers;
    }

}
