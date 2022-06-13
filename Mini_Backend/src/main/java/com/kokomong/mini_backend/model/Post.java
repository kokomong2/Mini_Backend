package com.kokomong.mini_backend.model;

import com.kokomong.mini_backend.dto.PostRequestDto;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Post extends Timestamped { //Entity class /

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;    //게시글 PK

    @Column(nullable = false)
    private String username;  // user fk

    @Column(nullable = false)
    private String img; //이미지 이름

    @Column(nullable = false)
    private String text;    //내용

    @OneToMany(mappedBy = "post", orphanRemoval = true)  //하나의 게시글에 여러개의 댓글 가질 수 있게
    private List<Comment> comments;




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
