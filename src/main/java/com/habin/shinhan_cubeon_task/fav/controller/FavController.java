package com.habin.shinhan_cubeon_task.fav.controller;

import com.habin.shinhan_cubeon_task.common.dto.ApiResponse;
import com.habin.shinhan_cubeon_task.fav.service.FavService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/fav")
public class FavController {

    private final FavService favService;

    @PutMapping("/{reviewId}/{userId}")
    public ResponseEntity<ApiResponse<Object>> fav(@PathVariable String userId, @PathVariable Long reviewId) {
        return favService.fav(userId, reviewId);
    }

}
