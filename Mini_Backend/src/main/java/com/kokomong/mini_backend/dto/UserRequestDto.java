package com.kokomong.mini_backend.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserRequestDto {
    private String username;
    private String password;
//    private String passwordCheck;
    private String nickname;
}