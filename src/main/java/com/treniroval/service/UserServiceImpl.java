package com.treniroval.service;

import com.treniroval.dao.interfase.UserDAO;
import com.treniroval.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService{

    private final UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional
    public User createUpdateUser(User user) {
        return userDAO.createUpdateUser(user);
    }

    @Override
    @Transactional
    public User getUser(Long id) {
        return userDAO.getUser(id);
    }

}
