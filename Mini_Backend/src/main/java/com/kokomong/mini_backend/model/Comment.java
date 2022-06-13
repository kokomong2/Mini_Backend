package com.kokomong.mini_backend.model;

import com.kokomong.mini_backend.dto.CommentRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;

@NoArgsConstructor
@Getter @Setter
@Entity
public class Comment extends Timestamped {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CommentId")
    private Long id;

    @Column(nullable = false)
    private Long userid;

    @Column(nullable = false)
    private String comment;

    @Column(nullable = false)
    private String nickname;

    @ManyToOne
    @JoinColumn(name = "postId, nullable = false") //Post 테이블의 Pk와 Join
    private Post post;

    public Comment (CommentRequestDto commentRequestDto, Post post) {
        this.comment = commentRequestDto.getComment();
    }

    public Long update(CommentRequestDto commentRequestDto) {
        this.comment = commentRequestDto.getComment();
        return id;
    }
}
