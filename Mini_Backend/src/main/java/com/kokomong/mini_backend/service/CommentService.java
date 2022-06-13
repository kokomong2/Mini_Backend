package com.kokomong.mini_backend.service;

import com.kokomong.mini_backend.dto.CommentRequestDto;
import com.kokomong.mini_backend.model.Comment;
import com.kokomong.mini_backend.model.Post;
import com.kokomong.mini_backend.repository.CommentRepository;
import com.kokomong.mini_backend.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    //댓글 작성
    @Transactional
    public Comment createComment(Long postId, CommentRequestDto commentsRequestDto) {
        Post post = postRepository.findByPostId(postId).orElseThrow(
                () -> new NullPointerException("해당 게시글이 존재하지 않습니다.")
        );
        Comment comment = new Comment(commentsRequestDto, post);
        commentRepository.save(comment);
        return comment;
    }

    //댓글 수정
    @Transactional
    public Long updateComment(Long commentId, CommentRequestDto commentRequestDto) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(
                () -> new NullPointerException("해당 댓글이 존재하지 않습니다")
        );
        return comment.update(commentRequestDto);
    }




    //댓글 삭제
    public Long deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
        return commentId;
    }
}
