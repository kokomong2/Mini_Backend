package com.kokomong.mini_backend.service;

import com.kokomong.mini_backend.dto.PostRequestDto;
import com.kokomong.mini_backend.model.Post;
import com.kokomong.mini_backend.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor    // final로 선언되면 생설할때 다 넣어줌
public class PostService {

    private final PostRepository postRepository;

    @Transactional  //업데이트할때 이게 DB에 진짜 반영이 되어야해 라고 한번 더 말해주는 어노테이션 *업데이트에 필수
    public Long update(Long postId, PostRequestDto requestDto) {
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new NullPointerException("아이디가 존재하지 않습니다.")
        );
        post.updatePost(requestDto);
        return post.getPostId();
    }


}
