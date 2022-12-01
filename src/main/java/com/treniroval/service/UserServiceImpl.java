package com.treniroval.service;

import com.treniroval.dao.interfase.UserDAO;
import com.treniroval.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService{

    private final UserDAO userDAO;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public User createUpdateUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User resUser = userDAO.createUpdateUser(user);
        log.info("created user : " + resUser);
        return resUser;
    }

    @Transactional
    public User getUser(Long id) {
        User resUser = userDAO.getUser(id);
        log.info("get user : " + resUser);
        return resUser;
    }

    @Transactional
    public User findByUsername(String login) {
        User resUser = userDAO.findByUsername(login);
        log.info("find user : " + resUser);
        return resUser;
    }


}
