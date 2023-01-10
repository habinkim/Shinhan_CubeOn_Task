package com.habin.shinhan_cubeon_task.user.controller;

import com.habin.shinhan_cubeon_task.common.dto.ApiResponse;
import com.habin.shinhan_cubeon_task.user.dto.SignUpRequestDto;
import com.habin.shinhan_cubeon_task.user.entity.User;
import com.habin.shinhan_cubeon_task.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "사용자 관리", description = "사용자 API")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @Tag(name = "사용자 관리", description = "사용자 API")
    @Operation(summary = "사용자 회원가입", description = "사용자 회원가입 API")
    @PostMapping("/signUp")
    public ResponseEntity<ApiResponse<Object>> signUp(@Valid @RequestBody SignUpRequestDto signUpRequestDto) {
        return userService.signUp(signUpRequestDto);
    }

    @Tag(name = "사용자 관리", description = "사용자 API")
    @Operation(summary = "사용자 리스트 조회", description = "사용자 리스트 조회 API")
    @GetMapping("/user")
    public ResponseEntity<ApiResponse<List<User>>> list() {
        return userService.list();
    }

}
