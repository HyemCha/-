package jpagoorm.postcrudapi.service;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
public class PostAndCommentDto {
    private String title;
    private Optional<List<String>> comment = Optional.empty();

    @Builder
    public PostAndCommentDto(String title, Optional<List<String>> comment) {
        this.title = title;
        this.comment = comment;
    }

    public PostAndCommentDto() {
    }

//    class Comment {
//        private String comment;
//    }
}
