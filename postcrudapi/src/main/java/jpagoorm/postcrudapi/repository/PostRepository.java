package jpagoorm.postcrudapi.repository;

import jakarta.persistence.EntityManager;
import jpagoorm.postcrudapi.domain.Post;
import jpagoorm.postcrudapi.service.PostAndCommentDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.persister.entity.EntityPersister;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class PostRepository {

    private final EntityManager em;

    public void save(Post post) {
        em.persist(post);
    }

    public Post findById(Long postId) {
        return em.find(Post.class, postId);
    }

    public Post findPostAndCommentById(Long postId) {
        return em.createQuery("select distinct p from Post p join fetch p.comments where p.id=:postId", Post.class)
                .setParameter("postId", postId)
                .getSingleResult();
    }

    public List<String> findAll() {
        return em.createQuery("select p.title from Post p", String.class)
                .getResultList();
    }
}
