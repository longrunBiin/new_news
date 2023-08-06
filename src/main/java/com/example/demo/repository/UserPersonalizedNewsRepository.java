package com.example.demo.repository;

import com.example.demo.domain.UserPersonalizedNews;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserPersonalizedNewsRepository {
    @PersistenceContext
    private EntityManager em;

    public void save(UserPersonalizedNews userPersonalizedNews) {
        em.persist(userPersonalizedNews);
    }

    public List<UserPersonalizedNews> findAll() {
        return em.createQuery("select u from UserPersonalizedNews u", UserPersonalizedNews.class)
                .getResultList();
    }
}
