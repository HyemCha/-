package com.example.demo.model.request.board;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BoardPostRequest implements Serializable {
  private String title;
  private String body;
}
