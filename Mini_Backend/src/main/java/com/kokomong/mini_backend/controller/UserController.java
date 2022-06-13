package com.kokomong.mini_backend.controller;


import com.kokomong.mini_backend.dto.SignupRequestDto;
import com.kokomong.mini_backend.dto.UserResponseDto;
import com.kokomong.mini_backend.model.User;
import com.kokomong.mini_backend.security.UserDetailsImpl;
import com.kokomong.mini_backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class
UserController {

    private final UserService userService;

    //회원가입
    @PostMapping("/api/signup")
    public boolean registerUser(@RequestBody SignupRequestDto requestDto) {

        try { // 회원가입 진행 성공시 true
            userService.registerUser(requestDto);
            return true;
        }catch (Exception e){ // 에러나면 false
            return false;
        }

    }

    @GetMapping("/api/auth")
    public UserResponseDto islogin(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        User user = userDetails.getUser();
        System.out.println("username : " + user.getUsername());
        System.out.println("nickname : " + user.getNickname());
        return new UserResponseDto(user.getUsername(), user.getNickname());
    }


    @PostMapping("/api/signup/checkid")
    public boolean checkid(@RequestBody SignupRequestDto requestDto){

        return userService.checkId(requestDto);
    }

}
