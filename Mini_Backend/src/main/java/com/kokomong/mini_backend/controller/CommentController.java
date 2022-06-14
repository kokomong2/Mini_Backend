package com.kokomong.mini_backend.controller;

import com.kokomong.mini_backend.dto.CommentRequestDto;
import com.kokomong.mini_backend.model.Comment;
import com.kokomong.mini_backend.repository.CommentRepository;
import com.kokomong.mini_backend.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService; // 서비스 사용하기 위해 변수선언, 생성자는 어노테이션으로
    private final CommentRepository commentRepository;

    //댓글 작성
    @PostMapping("/api/comment/{postId}")
    public Comment createComment(@PathVariable Long postId, @RequestBody CommentRequestDto commentRequestDto) {
        Comment comment = commentService.createComment(postId, commentRequestDto);
//        Comment comment = new Comment(postId, commentRequestDto);
//        return commentRepository.save(comment);
        return comment;
    }

    //댓글 삭제
    @DeleteMapping("/api/comment/{commentId}")
    public Long deleteComment(@PathVariable Long commentId) {

        return commentService.deleteComment(commentId);
    }

    //댓글 수정
    @PutMapping("/api/comment/{commentId}")
    public Long updateComment(@PathVariable Long commentId,
                              @RequestBody CommentRequestDto commentRequestDto) {
        return commentService.updateComment(commentId, commentRequestDto);
    }

    @GetMapping("/api/comment/{postId}")
    public List<Comment> getComment(@PathVariable Long postId) {

        return commentRepository.findAllByOrderByModifiedAtDesc();
    }


}
