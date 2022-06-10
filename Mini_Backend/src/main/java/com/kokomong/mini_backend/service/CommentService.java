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
    public void createComment(Long postid, CommentRequestDto commentsRequestDto) {
        Post post = postRepository.findById(postid).orElseThrow(
                () -> new NullPointerException("해당 게시글이 존재하지 않습니다.")
        );
        Comment comment = new Comment(commentsRequestDto, post);
        commentRepository.save(comment);
    }

    //댓글 수정
    @Transactional
    public Long updateComment(Long Commentid, CommentRequestDto commentRequestDto) {
        Comment comment = commentRepository.findById(Commentid).orElseThrow(
                () -> new NullPointerException("해당 댓글이 존재하지 않습니다")
        );
        return comment.update(commentRequestDto);
    }




    //댓글 삭제
    public Long deleteComment(Long Commentid) {
        commentRepository.deleteById(Commentid);
        return Commentid;
    }
}
