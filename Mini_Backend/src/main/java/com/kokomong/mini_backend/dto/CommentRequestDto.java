package com.kokomong.mini_backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentRequestDto {
    private String username;
    private String comment;
    private String nickname;
}
