package org.example.meberservice.controller;

import org.example.meberservice.dto.ModifyUserDto;
import org.example.meberservice.dto.RegisterUserDto;
import org.example.meberservice.entity.UserEntity;
import org.example.meberservice.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
public class MemberController {

    private final UserService userService;

    public MemberController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/member/users/registration")
    public UserEntity registerUser(@RequestBody RegisterUserDto dto) {
        return userService.registerUser(dto.loginId, dto.userName);
    }

    @PutMapping("/member/users/{userId}/modify")
    public UserEntity registerUser(
            @PathVariable final Long userId,
            @RequestBody final ModifyUserDto dto
    ) {
        return userService.modifyUser(userId, dto.userName);
    }

    @PostMapping("/member/users/{loginId}/login") // 지양해야할 설계이다.
    public UserEntity registerUser(
            @PathVariable final String loginId
    ) {
        return userService.getUser(loginId);
    }
}
