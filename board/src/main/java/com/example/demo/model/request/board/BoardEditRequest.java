package com.example.demo.model.request.board;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BoardEditRequest implements Serializable {
  private Long boardNo;
  private String body;
}
