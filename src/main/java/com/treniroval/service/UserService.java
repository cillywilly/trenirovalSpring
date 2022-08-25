package com.treniroval.service;

import com.treniroval.entity.User;

public interface UserService {
    int createUser(User user);

    User getUser(int id);
}
