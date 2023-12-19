package jpagoorm.postcrudapi.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Post {
    @Id @GeneratedValue
    @Column(name = "post_id")
    private Long id;
    private String title;
    private String content;
    @OneToMany(mappedBy = "post")
    private List<Comment> comments = new ArrayList<>();

    public Post() {

    }
}
