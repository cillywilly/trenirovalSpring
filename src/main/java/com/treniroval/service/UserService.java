package com.treniroval.service;

import com.treniroval.entity.User;

public interface UserService {
    User createUpdateUser(User user);

    User getUser(Long id);
}
