package com.kokomong.mini_backend.controller;

import com.kokomong.mini_backend.dto.CommentRequestDto;
import com.kokomong.mini_backend.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService; // 서비스 사용하기 위해 변수선언, 생성자는 어노테이션으로

    //댓글 작성
    @PostMapping("/api/comments/{postid}")
    public void createComment(@PathVariable Long postid, @RequestBody CommentRequestDto commentRequestDto) {
        commentService.createComment(postid, commentRequestDto);
    }

    //댓글 삭제
    @DeleteMapping()
    public Long deleteComment(@PathVariable Long Commentid) {
        return commentService.deleteComment(Commentid);
    }

    //댓글 수정
    @PutMapping
    public Long updateComment(@PathVariable Long Commentid,
                                         @RequestBody CommentRequestDto commentRequestDto) {
        return commentService.updateComment(Commentid, commentRequestDto);
    }


}
