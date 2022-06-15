package com.kokomong.mini_backend.controller;

import com.kokomong.mini_backend.dto.PostRequestDto;
import com.kokomong.mini_backend.dto.PostResponseDto;
import com.kokomong.mini_backend.model.Comment;
import com.kokomong.mini_backend.model.Post;
import com.kokomong.mini_backend.model.User;
import com.kokomong.mini_backend.repository.PostRepository;
import com.kokomong.mini_backend.security.UserDetailsImpl;
import com.kokomong.mini_backend.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostRepository postRepository;
    private final PostService postService;
    private User user;


    //게시글 생성
    @PostMapping("/api/post")
    public Post createPost(@AuthenticationPrincipal UserDetailsImpl userDetails, @RequestBody PostRequestDto requestDto) {
        User user = userDetails.getUser();
        String username = userDetails.getUsername();
        String nickname = userDetails.getUser().getNickname();
        String img = requestDto.getImg();
        String text = requestDto.getText();

        Post post = new Post(username, nickname, img, text);
        return postRepository.save(post);
    }

    //게시글 목록 불러오기
    @GetMapping("/api/main")
    public List<Post> getPost() {
        return postRepository.findAllByOrderByModifiedAtDesc();
    }

    // 게시글 상세 보기
    @GetMapping("/api/detail/{postid}")             //
    public Post detailPost(@PathVariable Long postid) {
        Post post = postRepository.findById(postid).orElseThrow(
                () -> new IllegalArgumentException("게시물이 존재하지 않습니다.")
        );
        return post;
    }

    //게시글 수정
    @PutMapping("/api/detail/update/{postId}")
    public Post updatePost(@PathVariable Long postId, @RequestBody PostRequestDto requestDto ) {
        postService.update(postId, requestDto);
        return postRepository.findByPostId(postId).orElseThrow(
                ()->new IllegalArgumentException("포스트 아이디 없음"));
    }

    //게시글 삭제
    @DeleteMapping("/api/detail/{postId}")
    public Long deletePost(@PathVariable Long postId) {
        postRepository.deleteById(postId);
        return postId;
    }
}
