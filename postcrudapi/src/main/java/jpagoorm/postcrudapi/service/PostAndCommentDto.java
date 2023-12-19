package jpagoorm.postcrudapi.service;

import lombok.Data;

@Data
public class PostAndCommentDto {
    private String title;
    private String comment;
}
