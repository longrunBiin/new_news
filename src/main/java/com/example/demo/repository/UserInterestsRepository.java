package com.example.demo.repository;

import com.example.demo.domain.UserInterests;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserInterestsRepository {
    @PersistenceContext
    private EntityManager em;

    public void save(UserInterests userInterests) {
        em.persist(userInterests);
    }

    public List<UserInterests> findAll() {
        return em.createQuery("select u from UserInterests u", UserInterests.class)
                .getResultList();
    }
    public List<UserInterests> findByInterest(String interest) {
        return em.createQuery("select u from UserInterests u where u.interest = :interest",
                        UserInterests.class)
                .setParameter("interest", interest)
                .getResultList();
    }
}
