package com.treniroval.dao.interfase;

import com.treniroval.entity.User;

public interface UserDAO {
    User getUser(int id);

    boolean createUser(User user);
}
