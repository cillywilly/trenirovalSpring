package com.treniroval.service;

import com.treniroval.config.Encriptor;
import com.treniroval.dao.interfase.UserDAO;
import com.treniroval.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserDAO userDAO;
    private final Encriptor passwordEncoder;

    @Transactional
    public User createUpdateUser(User user) {
        user.setPassword(passwordEncoder.passwordEncoder().encode(user.getPassword()));
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDAO.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("client not found");
        }
        log.info("loaded user : " + user);
        return user;
    }
}
