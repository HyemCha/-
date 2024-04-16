package jpagoorm.postcrudapi.service;

import jakarta.transaction.Transactional;
import jpagoorm.postcrudapi.domain.Comment;
import jpagoorm.postcrudapi.domain.Post;
import jpagoorm.postcrudapi.repository.PostRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public PostAndCommentDto findPostAndCommentById(Long postId) {
        Post foundPost = postRepository.findPostAndCommentById(postId);
        PostAndCommentDto post = PostAndCommentDto.builder()
                .title(foundPost.getTitle())
                .comment(Optional.ofNullable(foundPost.getComments().stream().map(Comment::getContent).collect(Collectors.toList())))
                .build();

        return post;
    }

    @Transactional
    public PostAndCommentDto updatePost(Long postId, String title, String content) {
        Post foundPost = postRepository.findById(postId);
        foundPost.setTitle(title);
        foundPost.setContent(content);
        PostAndCommentDto post = PostAndCommentDto.builder()
                .title(foundPost.getTitle())
                .comment(Optional.ofNullable(foundPost.getComments().stream().map(Comment::getContent).collect(Collectors.toList())))
                .build();
        return post;
    }

    @Transactional
    public List<String> findAllPost() {
        return postRepository.findAll();
    }
}
