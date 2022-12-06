package com.treniroval.dao.interfase;

import com.treniroval.entity.User;

import java.util.List;

public interface UserDAO {
    User getUser(Long id);

    User createUser(User user);

    User updateUserInfo(User user);

    User updateUserPassword(User user);

    User findByUsername(String login);

    List<User> getAllUsers();
}
