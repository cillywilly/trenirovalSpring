package com.treniroval.dao;

import com.treniroval.dao.interfase.UserDAO;
import com.treniroval.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class UserDAOImpl implements UserDAO {

    private final EntityManager entityManager;

    public UserDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public User getUser(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public boolean createUser(User user) {
        User newUser = entityManager.merge(user);
        user.setId(newUser.getId());
        return true;
    }
}
