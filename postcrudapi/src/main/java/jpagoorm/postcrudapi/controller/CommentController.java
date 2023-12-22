package jpagoorm.postcrudapi.controller;

import jpagoorm.postcrudapi.domain.Comment;
import jpagoorm.postcrudapi.service.CommentDto;
import jpagoorm.postcrudapi.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/post/{postId}/comment")
@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/add")
    public CommentDto addComment(@RequestBody Comment comment, @PathVariable Long postId) {
        return commentService.saveComment(postId, comment);
    }

    @PostMapping("/update")
    public Comment updateComment(@PathVariable Long postId, @RequestBody Comment comment) {
        return commentService.updateCommnet(comment.getId(), comment.getContent());
    }

    @DeleteMapping("/delete/{commentId}")
    public void deleteComment(@PathVariable Long postId, @PathVariable Long commentId) {

    }
}
