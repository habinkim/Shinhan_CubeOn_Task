package com.habin.shinhan_cubeon_task.user.controller;

import com.habin.shinhan_cubeon_task.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

}
