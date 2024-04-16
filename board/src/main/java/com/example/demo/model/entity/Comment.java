package com.example.demo.model.entity;

import com.example.demo.model.CommentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Getter
  private Long commentNo;

  @Getter
  @Setter
  private String body;

  @Getter
  @Setter
  @Enumerated(EnumType.STRING)
  private CommentStatus commentStatus;

  public boolean isActive() {
    return commentStatus == CommentStatus.ACTIVE;
  }

  @Getter
  @Setter
  @ManyToOne(fetch = FetchType.LAZY)
  private Board board;
}
