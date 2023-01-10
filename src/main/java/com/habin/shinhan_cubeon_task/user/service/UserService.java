package com.habin.shinhan_cubeon_task.user.service;

import com.habin.shinhan_cubeon_task.common.dto.ApiResponse;
import com.habin.shinhan_cubeon_task.user.dto.SignUpRequestDto;
import com.habin.shinhan_cubeon_task.user.mapper.UserMapper;
import com.habin.shinhan_cubeon_task.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Transactional
    public ResponseEntity<ApiResponse<Object>> signUp(SignUpRequestDto signUpRequestDto) {
        userRepository.findById(signUpRequestDto.getUserId())
                .ifPresentOrElse(u -> {
                    throw new IllegalArgumentException("이미 존재하는 아이디입니다.");
                }, () -> userRepository.save(userMapper.toEntity(signUpRequestDto)));

        return ApiResponse.success();
    }
}
