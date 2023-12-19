package jpagoorm.postcrudapi.service;

import jpagoorm.postcrudapi.domain.Post;
import jpagoorm.postcrudapi.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public void savePost(Post post) {
        postRepository.save(post);
    }

    @Transactional
    public Post findPostById(Long postId) {
        return postRepository.findById(postId);
    }

    @Transactional
    public Post findPostAndCommentById(Long postId) {
        return postRepository.findPostAndCommentById(postId);
    }

    @Transactional
    public void updatePost(Long postId, String title, String content) {
        Post foundPost = postRepository.findById(postId);
        foundPost.setTitle(title);
        foundPost.setContent(content);
    }

    @Transactional
    public List<String> findAllPost() {
        return postRepository.findAll();
    }
}
