package com.treniroval.dao.interfase;

import com.treniroval.entity.User;

public interface UserDAO {
    User getUser(Long id);

    User createUpdateUser(User user);

}
