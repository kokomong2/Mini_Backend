package com.kokomong.mini_backend.controller;

import com.kokomong.mini_backend.dto.PostRequestDto;
import com.kokomong.mini_backend.model.Post;
import com.kokomong.mini_backend.repository.PostRepository;
import com.kokomong.mini_backend.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostRepository postRepository;
    private final PostService postService;


    //게시글 생성
    @PostMapping("/api/post")
    public boolean createPost(@RequestBody PostRequestDto requestDto) {
        Post post = new Post(requestDto);
        postRepository.save(post);
        return true;
    }

    //게시글 목록 불러오기
    @GetMapping("/api/post")
    public List<Post> getPost() {
        return postRepository.findAllByOrderByModifiedAtDesc();
    }

    //게시글 상세 보기
//    @GetMapping("/api/detail/{postid}")
//    public Post detailPost() {
//
//        return ;
//    }

    //게시글 수정
    @PutMapping("/api/detail/{postId}")
    public Long updatePost(@PathVariable Long postId, @RequestBody PostRequestDto requestDto ) {
        postService.update(postId, requestDto);

        return postId;    //임시
    }
}
