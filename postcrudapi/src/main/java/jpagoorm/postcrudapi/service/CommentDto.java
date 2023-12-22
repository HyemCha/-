package jpagoorm.postcrudapi.service;

import lombok.Builder;
import lombok.Data;

@Data
public class CommentDto {
    private String content;

    @Builder
    public CommentDto(String content) {
        this.content = content;
    }
}
