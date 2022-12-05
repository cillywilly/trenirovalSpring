package com.treniroval.service;

import com.treniroval.entity.User;

public interface UserService {
    User createUser(User user);
    User updateUserInfo(User user);
    User updateUserPassword(User user);

    User getUser(Long id);

    User findByUsername(String login);

}
