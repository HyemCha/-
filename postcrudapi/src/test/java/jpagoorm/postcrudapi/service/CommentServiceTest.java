package jpagoorm.postcrudapi.service;

import jpagoorm.postcrudapi.domain.Comment;
import jpagoorm.postcrudapi.repository.CommentRepository;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class CommentServiceTest {

    @Autowired
    CommentService service;

    @Autowired
    CommentRepository repository;

    @Test
    void saveComment() {
        Comment comment = Comment.builder()
                .content("댓글1")
                .build();

        service.saveComment(comment);

        Comment foundComment = service.findById(comment.getId());

        assertThat(foundComment.getId()).isEqualTo(comment.getId());
        assertThat(foundComment.getContent()).isEqualTo(comment.getContent());
    }

    @Test
    void updateCommnet() {
        Comment comment = Comment.builder()
                .content("내용1")
                .build();

        service.saveComment(comment);

        Comment foundComment = service.findById(comment.getId());
        foundComment.setContent("내용2");

        assertThat(foundComment.getContent()).isEqualTo(comment.getContent());
    }
}