package com.treniroval.service;

import com.treniroval.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User createUpdateUser(User user);

    User getUser(Long id);

    User findByUsername(String login);

}
