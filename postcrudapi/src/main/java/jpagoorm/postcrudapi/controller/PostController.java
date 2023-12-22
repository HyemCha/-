package jpagoorm.postcrudapi.controller;

import jpagoorm.postcrudapi.domain.Comment;
import jpagoorm.postcrudapi.domain.Post;
import jpagoorm.postcrudapi.service.PostAndCommentDto;
import jpagoorm.postcrudapi.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService service;

    @PostMapping("/add")
    public String addPost(@RequestBody Post post) {
        service.savePost(post);
        return "ok";
    }

    @GetMapping("/{postId}")
    public PostAndCommentDto findPost(@PathVariable Long postId) {
        return service.findPostAndCommentById(postId);
    }

    @PostMapping("/{postId}/update")
    public PostAndCommentDto updatePost(@PathVariable Long postId, @RequestBody Post post) {
        return service.updatePost(postId, post.getTitle(), post.getContent());
    }
}
