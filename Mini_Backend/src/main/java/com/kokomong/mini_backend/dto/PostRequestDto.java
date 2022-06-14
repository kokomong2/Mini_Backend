package com.kokomong.mini_backend.dto;

import com.kokomong.mini_backend.model.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;


@Getter
public class PostRequestDto {   //게시글 생성과 수정을 처리할 요청 Dto

    private String username;
    private String img;     //이미지
    private String text;    //내용
}


