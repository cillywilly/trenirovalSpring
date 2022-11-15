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

    private static final String GET_USER_BY_ID = "SELECT * FROM usr WHERE ID = ?";
    private static final String INSERT_USER = "INSERT INTO usr (login, password, active, email) values (?, ?, ?, ?)";
    private static final String UPDATE_USER = "UPDATE usr SET login = ?, password = ? WHERE id = ?";
    private static final String GET_USER_BY_LOGIN = "SELECT * FROM usr WHERE LOGIN = ?";


    @Override
    public User getUser(Long id) {
        return jdbcTemplate.queryForObject(GET_USER_BY_ID, BeanPropertyRowMapper.newInstance(User.class), id);
    }

    @Override
    public User createUpdateUser(User user) {
        if (user.getId() == null) {
            jdbcTemplate.update(INSERT_USER, user.getLogin(), user.getPassword(), user.getActive(), user.getEmail());
            return null;
        } else {
            jdbcTemplate.update(UPDATE_USER, user.getLogin(), user.getPassword(), user.getId());
            return getUser(user.getId());
        }

    }

    @Override
    public User getUserByLogin(String login) {
        var list = jdbcTemplate.query(GET_USER_BY_LOGIN, BeanPropertyRowMapper.newInstance(User.class), login);
        if (list.size() == 1) {
            return list.get(0);
        } else return null;
    }

}
