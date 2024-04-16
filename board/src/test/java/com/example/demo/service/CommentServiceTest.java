package com.example.demo.service;

import com.example.demo.model.response.BoardResponse;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class CommentServiceTest {

    @Autowired private CommentService commentService;
    @Autowired private BoardService boardService;

    @Test
    void postComment() {
        BoardResponse boardResponse = boardService.writeBoard("title", "body");
        BoardResponse boardResponse1 = commentService.postComment(boardResponse.getBoardNo(), "dd");
        log.info("test ={}", boardResponse1);
    }
}