package jpagoorm.postcrudapi.service;

import jakarta.persistence.EntityManager;
import jpagoorm.postcrudapi.domain.Comment;
import jpagoorm.postcrudapi.domain.Post;
import jpagoorm.postcrudapi.repository.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class PostServiceTest {

    @Autowired
    PostService service;

    @Autowired
    CommentService commentService;

    @Autowired
    PostRepository repository;

    @Autowired
    EntityManager em;

    @Test
    void savePost() {
        Post post = new Post();
        post.setTitle("제목");
        post.setContent("내용");

        service.savePost(post);

        Post foundPost = service.findPostById(post.getId());
        assertThat(foundPost.getId()).isEqualTo(post.getId());
    }

    @Test
    void findPostAndCommentById() {
        Post post = new Post();
        post.setTitle("제목");
        post.setContent("내용");

        service.savePost(post);

        Comment comment1 = Comment.builder()
                .content("댓글댓글1")
                .build();
        Comment comment2 = new Comment();
        comment2.setContent("댓글2");

        comment1.addCommentToPost(post);
        comment2.addCommentToPost(post);

        commentService.saveComment(comment1);
        commentService.saveComment(comment2);

        Post foundPost = service.findPostAndCommentById(post.getId());

        Comment foundComment = commentService.findById(comment1.getId());
        assertThat(foundComment.getPost().getId()).isEqualTo(post.getId());

        log.info("post title={}", foundPost.getTitle());
        log.info("post comment size={}", foundPost.getComments().size());
        for (Comment comment : foundPost.getComments()) {
            log.info("comment={}", comment.getContent());
        }

//        em.clear();
//        List<Post> resultList = em.createQuery("select p from Post p join fetch p.comments", Post.class)
//                .getResultList();
//        for (Post post1 : resultList) {
//            log.info("resultList={}", post1.getContent());
//            for (Comment comment : post1.getComments()) {
//                log.info("comment={}", comment.getContent());
//            }
//        }
    }

    @Test
    void updatePost() {
        Post post = new Post();
        post.setTitle("제목");
        post.setContent("내용");

        service.savePost(post);

        Post foundPost = service.findPostById(post.getId());

        service.updatePost(foundPost.getId(), "바꿈", "바꿈2");

        assertThat(foundPost.getTitle()).isEqualTo(post.getTitle());
    }

    @Test
    void findAllPost() {
        Post post1 = new Post();
        post1.setTitle("제목");
        post1.setContent("내용");
        Post post2 = new Post();
        post2.setTitle("제목2");
        post2.setContent("내용2");

        service.savePost(post1);
        service.savePost(post2);

        List<String> posts = service.findAllPost();
        log.info("posts={}", posts);
    }
}