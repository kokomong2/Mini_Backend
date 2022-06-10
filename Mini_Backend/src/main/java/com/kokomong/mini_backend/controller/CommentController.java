package com.kokomong.mini_backend.controller;

import com.kokomong.mini_backend.dto.CommentRequestDto;
import com.kokomong.mini_backend.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    //댓글 작성
    @PostMapping("/api/comments/{postId}")
    public void createComment(@PathVariable Long postId, @RequestBody CommentRequestDto commentRequestDto) {
        commentService.createComment(postId, commentRequestDto);
    }

    //댓글 삭제
    @DeleteMapping()
    public Long deleteComment(@PathVariable Long commentId) {
        return commentService.deleteComment(commentId);
    }

    //댓글 수정
    @PutMapping
    public Long updateComment(@PathVariable Long commentId,
                                         @RequestBody CommentRequestDto commentRequestDto) {
        return commentService.updateComment(commentId, commentRequestDto);
    }


}
