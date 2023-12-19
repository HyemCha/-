package jpagoorm.postcrudapi.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Comment {
    @Id @GeneratedValue
    @Column(name = "comment_id")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "POST_ID")
    private Post post;
    private String content;

    // 연관관계 편의 메서드
    public void addCommentToPost(Post post) {
        this.post = post;
        post.getComments().add(this);
    }

    @Builder
    public Comment(Long id, Post post, String content) {
        this.id = id;
        this.post = post;
        this.content = content;
    }

    public Comment() {

    }
}
