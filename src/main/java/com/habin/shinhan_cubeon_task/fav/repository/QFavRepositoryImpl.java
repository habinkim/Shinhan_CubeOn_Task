package com.habin.shinhan_cubeon_task.fav.repository;

import com.habin.shinhan_cubeon_task.fav.entity.Fav;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

import static com.habin.shinhan_cubeon_task.fav.entity.QFav.fav;
import static com.habin.shinhan_cubeon_task.review.entity.QReview.review;
import static com.habin.shinhan_cubeon_task.user.entity.QUser.user;
import static java.util.Optional.ofNullable;

@RequiredArgsConstructor
public class QFavRepositoryImpl implements QFavRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public Optional<Fav> getFav(String userId, Long reviewId) {
        return ofNullable(
                queryFactory.selectFrom(fav)
                        .join(fav.review, review)
                        .join(fav.user, user)
                        .where(user.userId.eq(userId), review.reviewId.eq(reviewId))
                        .fetchOne()
        );
    }
}
