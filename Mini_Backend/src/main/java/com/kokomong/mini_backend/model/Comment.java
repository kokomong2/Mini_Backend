package com.kokomong.mini_backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @Column(name = "commentId")
    private Long id;

    @Column(nullable = false)
    private Long userid;

    @Column(nullable = false)
    private String comment;

    @Column(nullable = false)
    private String nickname;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "POST_ID")
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
