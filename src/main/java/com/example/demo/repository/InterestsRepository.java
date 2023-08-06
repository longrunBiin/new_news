package com.example.demo.repository;

import com.example.demo.domain.Interests;
import com.example.demo.domain.Users;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InterestsRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Interests interests) {
        em.persist(interests);
    }

    public List<Interests> findAll() {
        return em.createQuery("select i from Interests i", Interests.class)
                .getResultList();
    }
    public Interests findByInterestName(String interestName) {
         return em.createQuery("select i from Interests i where i.interestName = :interestName", Interests.class)
                .setParameter("interestName", interestName)
                 .getSingleResult();

    }
    public Interests findByInterestId(Long interestId) {
        return em.find(Interests.class, interestId);
    }

}
