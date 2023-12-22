package jpagoorm.postcrudapi.service;

import jpagoorm.postcrudapi.domain.Comment;
import jpagoorm.postcrudapi.repository.CommentRepository;
import jpagoorm.postcrudapi.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository repository;
    private final PostService postService;

    @Transactional
    public CommentDto saveComment(Long postId, Comment comment) {
        repository.save(comment);
        comment.addCommentToPost(postService.findPostById(postId));
        return CommentDto.builder()
                .content(comment.getContent())
                .build();
    }

    @Transactional
    public Comment findById(Long commentId) {
        return repository.findById(commentId);
    }


    @Transactional
    public Comment updateCommnet(Long commentId, String content) {
        Comment foundComment = repository.findById(commentId);
        foundComment.setContent(content);
        return foundComment;
    }

    @Transactional
    public void deleteComment(Long commentId) {
        Comment foundComment = repository.findById(commentId);
    }
}
