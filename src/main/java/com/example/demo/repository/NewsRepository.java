package com.example.demo.repository;

import com.example.demo.domain.Interests;
import com.example.demo.domain.News;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NewsRepository {
    @PersistenceContext
    private EntityManager em;

    public void save(News news) {
        em.persist(news);
    }
    public List<News> findAll() {
        return em.createQuery("select n from News n", News.class)
                .getResultList();
    }

    public List<News> findByTitle(String title) {
        return em.createQuery("select n from News n where n.title = :title",
                        News.class)
                .setParameter("title", title)
                .getResultList();
    }

    public List<News> findByCategory(String category) {
        return em.createQuery("select n from News n where n.category = :category",
                        News.class)
                .setParameter("category", category)
                .getResultList();
    }

    public List<News> findBySource(String source) {
        return em.createQuery("select n from News n where n.source = :source",
                        News.class)
                .setParameter("source", source)
                .getResultList();
    }

}
