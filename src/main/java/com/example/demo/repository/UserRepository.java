package com.example.demo.repository;

import com.example.demo.domain.Users;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Member;
import java.util.List;

@Repository
public class UserRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Users users) {
        em.persist(users);
    }
    public Users findOne(Long id) {
        return em.find(Users.class, id);
    }
    public List<Users> findAll() {
        return em.createQuery("select u from Users u", Users.class)
                .getResultList();
    }
    public List<Users> findByName(String name) {
        return em.createQuery("select u from Users u where u.userName = :name",
                        Users.class)
                .setParameter("name", name)
                .getResultList();
    }
}
