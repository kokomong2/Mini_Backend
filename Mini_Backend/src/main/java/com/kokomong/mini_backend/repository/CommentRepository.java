package com.kokomong.mini_backend.repository;

import com.kokomong.mini_backend.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository <Comment, Long>{
    List<Comment> findByPostOrderByModifiedAtDesc(Long id);
}
