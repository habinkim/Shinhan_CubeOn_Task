package com.habin.shinhan_cubeon_task.fav.service;

import com.habin.shinhan_cubeon_task.common.dto.ApiResponse;
import com.habin.shinhan_cubeon_task.fav.mapper.FavMapper;
import com.habin.shinhan_cubeon_task.fav.repository.FavRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class FavService {

    private final FavRepository favRepository;
    private final FavMapper favMapper;

    @Transactional
    public ResponseEntity<ApiResponse<Object>> fav(String userId, Long reviewId) {
        favRepository.getFav(userId, reviewId)
                .ifPresentOrElse(favRepository::delete, () -> favRepository.save(favMapper.toEntity(userId, reviewId)));

        return ApiResponse.success();
    }
}
