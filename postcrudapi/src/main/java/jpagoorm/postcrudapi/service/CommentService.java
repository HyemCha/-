package jpagoorm.postcrudapi.service;

import jpagoorm.postcrudapi.domain.Comment;
import jpagoorm.postcrudapi.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository repository;

    public void saveComment(Comment comment) {
        repository.save(comment);
    }

    public Comment findById(Long commentId) {
        return repository.findById(commentId);
    }

    public void updateCommnet(Long commentId, String content) {
        Comment foundComment = repository.findById(commentId);
        foundComment.setContent(content);
    }
}
