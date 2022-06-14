package com.kokomong.mini_backend.dto;

import com.kokomong.mini_backend.model.Comment;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CommentRequestDto {
    private LocalDateTime modifiedAt;
    private Long commentId;
    private String username;
    private String comment;
    private String nickname;

    public CommentRequestDto(Comment comment) {
        this.commentId = comment.getCommentId();
        this.nickname = comment.getNickname();
        this.comment = comment.getComment();
        this.modifiedAt = comment.getModifiedAt();
    }
}
