package com.treniroval.service;

import com.treniroval.dao.interfase.UserDAO;
import com.treniroval.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

import javax.sql.DataSource;
import java.util.List;

@RequiredArgsConstructor
public class CustomUserDetailsManager {

    private final UserDAO userDAO;

    @Bean
    UserDetailsManager users(DataSource dataSource) {
        List<User> usersList = userDAO.getAllUsers();
        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
        usersList.forEach(users::createUser);
        return users;
    }

}
