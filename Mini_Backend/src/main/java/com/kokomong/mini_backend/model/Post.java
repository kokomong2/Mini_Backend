package com.kokomong.mini_backend.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.kokomong.mini_backend.dto.PostRequestDto;
import com.kokomong.mini_backend.security.UserDetailsImpl;
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
    private String nickname;

    @Column(nullable = false)
    private String img; //이미지 이름

    @Column(nullable = false)
    private String text;    //내용



    @JsonManagedReference
    @OneToMany(mappedBy = "post", orphanRemoval = true)
    private List<Comment> comments;

    public Post(String username, String nickname, String img, String text) {
        this.username = username;
        this.nickname = nickname;
        this.img = img;
        this.text = text;
    }

//    public Post(User user, PostRequestDto requestDto) {
//       this.username = user.getUsername();
//       this.nickname = user.getNickname();
//        this.img = requestDto.getImg();
//        this.text = requestDto.getText();
//
//    }


//    //게시글 생성
//    public Post(PostRequestDto requestDto) {
//        this.username = requestDto.getUsername();
//        this.img = requestDto.getImg();
//        this.text = requestDto.getText();
//
//    }


    //게시글 수정
    public void updatePost(PostRequestDto requestDto) {
        this.text = requestDto.getText();
    }
}
