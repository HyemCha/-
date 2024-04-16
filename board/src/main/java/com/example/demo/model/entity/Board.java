package com.example.demo.model.entity;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Where;

import com.example.demo.model.BoardStatus;
import com.example.demo.model.CommentStatus;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Board {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Getter
  private Long boardNo;

  @Getter
  @Setter
  private String title;

  @Getter
  @Setter
  private String body;

  @Getter
  @Setter
  @Enumerated(EnumType.STRING)
  private BoardStatus boardStatus;

  public boolean isActive() {
    return this.boardStatus == BoardStatus.ACTIVE;
  }

  public void doClose() {
    this.boardStatus = BoardStatus.DELETE;
  }

  @Getter
  @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
  @Where(clause = "comment_status = 'ACTIVE'")
  private List<Comment> comments = new ArrayList<>();


  public Board addComment(String commentBody) {
    Comment comment = new Comment();
    comment.setBody(commentBody);
    comment.setBoard(this);
    comment.setCommentStatus(CommentStatus.ACTIVE);
    this.comments.add(comment);
    return this;
  }
}
