package com.treniroval.dao;

import com.treniroval.dao.interfase.UserDAO;
import com.treniroval.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserDAOImpl implements UserDAO {

    private final JdbcTemplate jdbcTemplate;

    private static final String GET_USER_BY_ID = "SELECT * FROM `USER` WHERE ID = ?";
    private static final String INSERT_USER = "INSERT INTO `USER` (login, password) values (?, ?)";
    private static final String UPDATE_PERSON = "UPDATE `USER` SET login = ?, password = ? WHERE id = ?";

    @Override
    public User getUser(int id) {
        return jdbcTemplate.queryForObject(GET_USER_BY_ID, BeanPropertyRowMapper.newInstance(User.class), id);
    }

    @Override
    public int createUser(User user) {
        return jdbcTemplate.update(INSERT_USER, user.getLogin(), user.getPassword());
    }

    @Override
    public User updateUser(User user) {
        if (getUser(user.getId()) == null) {
            return null;
        } else {
             jdbcTemplate.update(UPDATE_PERSON, user.getLogin(), user.getPassword(), user.getId());
            return getUser(user.getId());
        }

    }
}
