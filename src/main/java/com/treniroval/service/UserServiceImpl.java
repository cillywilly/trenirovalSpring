package com.treniroval.service;

import com.treniroval.dao.interfase.UserDAO;
import com.treniroval.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService , UserDetailsService {

    private final UserDAO userDAO;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User resUser = userDAO.createUser(user);
        log.info("created user : " + resUser);
        return resUser;
    }

    @Transactional
    public User updateUserInfo(User user) {
        User resUser = userDAO.updateUserInfo(user);
        log.info("updateUserInfo : " + resUser);
        return resUser;
    }

    @Transactional
    public User updateUserPassword(User user) {
        User resUser = userDAO.updateUserPassword(user);
        log.info("update pass for user : " + resUser);
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


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("client not found");
        }
        log.info("loaded user : " + user);
        return user;
    }
}
