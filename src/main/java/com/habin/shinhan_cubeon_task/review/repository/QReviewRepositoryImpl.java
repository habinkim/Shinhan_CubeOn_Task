package com.habin.shinhan_cubeon_task.review.repository;

import com.habin.shinhan_cubeon_task.review.dto.ReviewListDto;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.List;

import static com.habin.shinhan_cubeon_task.review.entity.QLecture.lecture;
import static com.habin.shinhan_cubeon_task.review.entity.QReview.review;
import static com.habin.shinhan_cubeon_task.user.entity.QUser.user;
import static com.querydsl.core.types.Projections.fields;
import static org.springframework.data.support.PageableExecutionUtils.getPage;

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

        return getPage(fetch, pageRequest, countQuery::fetchOne);
    }

    private OrderSpecifier<?>[] getOrderSpecifier(Boolean recent, Order grade) {
        List<OrderSpecifier<?>> orderSpecifiers = new ArrayList<>();
        orderSpecifiers.add(review.favCount.desc());

        if (recent != null && recent) {
            orderSpecifiers.add(review.createdAt.desc());
        }

        if(grade != null) {
            switch (grade) {
                case ASC -> {
                    orderSpecifiers.add(review.grade.asc());
                }
                case DESC -> {
                    orderSpecifiers.add(review.grade.desc());
                }
            }
        }

        return orderSpecifiers.toArray(OrderSpecifier[]::new);
    }

}
