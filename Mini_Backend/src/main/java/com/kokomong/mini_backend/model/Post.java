package com.kokomong.mini_backend.model;

import com.kokomong.mini_backend.dto.PostRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Post extends Timestamped { //Entity class /

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;    //게시글 PK

    @Column(nullable = false)
    private String username;  // user fk

    @Column(nullable = false)
    private String img; //이미지

    @Column(nullable = false)
    private String text;    //내용


    //게시글 생성
    public Post(PostRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.img = requestDto.getImg();
        this.text = requestDto.getText();

    }

    //게시글 수정
    public void updatePost(PostRequestDto requestDto) {
        this.text = requestDto.getText();
    }
}
