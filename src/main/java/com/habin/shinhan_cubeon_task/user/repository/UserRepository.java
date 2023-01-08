package com.habin.shinhan_cubeon_task.user.repository;

import com.habin.shinhan_cubeon_task.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String>, QUserRepository {
}
