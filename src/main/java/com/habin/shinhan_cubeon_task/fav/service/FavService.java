package com.habin.shinhan_cubeon_task.fav.service;

import com.habin.shinhan_cubeon_task.common.dto.ApiResponse;
import com.habin.shinhan_cubeon_task.fav.entity.Fav;
import com.habin.shinhan_cubeon_task.fav.mapper.FavMapper;
import com.habin.shinhan_cubeon_task.fav.repository.FavRepository;
import com.habin.shinhan_cubeon_task.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class FavService {

    private final FavRepository favRepository;
    private final ReviewRepository reviewRepository;
    private final FavMapper favMapper;

    @Transactional
    public ResponseEntity<ApiResponse<Object>> fav(String userId, Long reviewId) {
        favRepository.getFav(userId, reviewId)
                .ifPresentOrElse(entity -> {
                            favRepository.delete(entity);
                            reviewRepository.decreaseFavCount(reviewId);
                        }, () -> {
                            Fav fav = favMapper.toEntity(userId, reviewId);
                            favRepository.save(fav);
                            reviewRepository.increaseFavCount(reviewId);
                        }
                );

        return ApiResponse.success();
    }
}
