package com.kokomong.mini_backend.controller;

import com.kokomong.mini_backend.dto.CommentRequestDto;
import com.kokomong.mini_backend.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService; // 서비스 사용하기 위해 변수선언, 생성자는 어노테이션으로

    //댓글 작성
    @PostMapping("/api/comments/{postId}")
    public void createComment(@PathVariable Long postId, @RequestBody CommentRequestDto commentRequestDto) {
        commentService.createComment(postId, commentRequestDto);
    }

    //댓글 삭제
    @DeleteMapping("api/comment/{commentId}")
    public Long deleteComment(@PathVariable Long CommentId) {
        return commentService.deleteComment(CommentId);
    }

    //댓글 수정
    @PutMapping("api/comment/{commentId}")
    public Long updateComment(@PathVariable Long CommentId,
                                         @RequestBody CommentRequestDto commentRequestDto) {
        return commentService.updateComment(CommentId, commentRequestDto);
    }


}
