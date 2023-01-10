package com.habin.shinhan_cubeon_task.fav.controller;

import com.habin.shinhan_cubeon_task.common.dto.ApiResponse;
import com.habin.shinhan_cubeon_task.fav.service.FavService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "강의 리뷰 좋아요 관리 - /fav", description = "강의 리뷰 좋아요 정보 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/fav")
public class FavController {

    private final FavService favService;

    @Tag(name = "강의 리뷰 좋아요 관리 - /fav", description = "강의 리뷰 좋아요 정보 API")
    @Operation(summary = "강의 리뷰 좋아요", description = "강의 리뷰 좋아요 API")
    @PutMapping("/{reviewId}/{userId}")
    public ResponseEntity<ApiResponse<Object>> fav(@PathVariable String userId, @PathVariable Long reviewId) {
        return favService.fav(userId, reviewId);
    }

}
