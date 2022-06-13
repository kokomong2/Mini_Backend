package com.kokomong.mini_backend.model;

import com.kokomong.mini_backend.dto.CommentRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
<<<<<<< HEAD
=======

>>>>>>> 38ac6a16550dc0c4b234a5cca59e2cb00c1cfe12

import javax.persistence.*;

@NoArgsConstructor
@Getter @Setter
@Entity
public class Comment extends Timestamped {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commentId")
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
        this.post = post;
    }

    public Long update(CommentRequestDto commentRequestDto) {
        this.comment = commentRequestDto.getComment();
        return id;
    }
}
