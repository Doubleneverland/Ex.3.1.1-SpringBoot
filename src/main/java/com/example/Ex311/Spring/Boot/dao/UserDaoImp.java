package com.example.Ex311.Spring.Boot.dao;


import com.example.Ex311.Spring.Boot.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void save(User user) {
        if (user != null) {
            entityManager.persist(user);
        }

    }

    public List<User> userPage(long id) {
        TypedQuery<User> query =
                entityManager.createQuery("SELECT u FROM User u where u.id = :userID", User.class);
        query.setParameter("userID", id);
        return query.getResultList();
    }


    @Override
    public List<User> read() {

        TypedQuery<User> query = (TypedQuery<User>) entityManager.createQuery("from User ");

        return query.getResultList();
    }

    @Override
    public User update(long id, String name, String lastname) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            user.setName(name);
            user.setLastName(lastname);
            entityManager.merge(user);
        }
        return user;
    }

    @Override
    public User upPage(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void delete(long id) {
        entityManager.createQuery("DELETE FROM User u WHERE u.id = :userId")
                .setParameter("userId", id)
                .executeUpdate();
    }

}
