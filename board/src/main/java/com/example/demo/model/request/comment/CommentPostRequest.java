package com.example.demo.model.request.comment;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommentPostRequest implements Serializable {
  private Long boardNo;
  private String commentBody;
}
