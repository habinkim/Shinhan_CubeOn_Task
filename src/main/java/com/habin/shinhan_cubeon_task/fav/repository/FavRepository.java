package com.habin.shinhan_cubeon_task.fav.repository;

import com.habin.shinhan_cubeon_task.fav.entity.Fav;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavRepository extends JpaRepository<Fav, Long>, QFavRepository {
}
