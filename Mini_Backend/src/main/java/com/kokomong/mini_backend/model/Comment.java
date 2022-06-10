package com.kokomong.mini_backend.model;

import com.kokomong.mini_backend.dto.CommentRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@Getter @Setter
@Entity
public class Comment extends Timestamped {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Commentid")
    private Long id;

    @Column(nullable = false)
    private Long userid;

    @Column(nullable = false)
    private Long postid;

    @Column(nullable = false)
    private String comment;

    @Column(nullable = false)
    private String nickname;

    public Comment (CommentRequestDto commentRequestDto, Post post) {this.comment = commentRequestDto.getComment();
    }

    public Long update(CommentRequestDto commentRequestDto) {
        this.comment = commentRequestDto.getComment();
        return id;
    }
}
