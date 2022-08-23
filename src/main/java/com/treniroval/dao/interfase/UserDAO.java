package com.treniroval.dao.interfase;

import com.treniroval.entity.User;

public interface UserDAO {
    User getUser(int id);

    int createUser(User user);

    User updateUser(User user);
}
