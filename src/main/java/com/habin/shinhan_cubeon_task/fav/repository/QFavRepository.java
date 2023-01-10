package com.habin.shinhan_cubeon_task.fav.repository;

import com.habin.shinhan_cubeon_task.fav.entity.Fav;

import java.util.Optional;

public interface QFavRepository {

    Optional<Fav> getFav(String userId, Long reviewId);

}
