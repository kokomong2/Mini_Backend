package com.kokomong.mini_backend.dto;

import lombok.Getter;

@Getter
public class CommentRequestDto {
    private String username;
    private String comment;
    private String nickname;
}
