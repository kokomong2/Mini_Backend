package com.kokomong.mini_backend.dto;

import com.kokomong.mini_backend.model.Timestamped;
import com.kokomong.mini_backend.security.UserDetailsImpl;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class PostResponseDto {  //게시글 정보를 리턴할 응답Dto

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    private String text;

    private String img;

    private String username;

    private String nickname;

    public PostResponseDto(PostRequestDto postRequestDto, UserDetailsImpl userDetails) {
        this.text = postRequestDto.getText();
        this.img = postRequestDto.getImg();
        this.username = userDetails.getUsername();
        this.nickname = userDetails.getUser().getNickname();
    }
}

