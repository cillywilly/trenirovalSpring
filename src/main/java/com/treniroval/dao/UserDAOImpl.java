package com.treniroval.dao;

import com.treniroval.dao.interfase.UserDAO;
import com.treniroval.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class UserDAOImpl implements UserDAO {

    private final JdbcTemplate jdbcTemplate;

    private static final String GET_USER_BY_ID = "SELECT * FROM usr WHERE ID = ?";
    private static final String INSERT_USER = "INSERT INTO usr (login, password, active, email) values (?, ?, ?, ?)";
    private static final String INSERT_USER_ROLE = "INSERT INTO user_role (user_id, roles) values (?,?)";
    private static final String UPDATE_USER = "UPDATE usr SET login = ?, password = ? WHERE id = ?";
    private static final String GET_USER_BY_LOGIN = "SELECT * FROM usr WHERE LOGIN = ?";
    private static final String GET_ALL_USERS = "SELECT * FROM usr";


    @Override
    public User getUser(Long id) {
        log.info("getUser by  id : " + id);
        return jdbcTemplate.queryForObject(GET_USER_BY_ID, BeanPropertyRowMapper.newInstance(User.class), id);
    }

    @Override
    public User createUpdateUser(User user) {
        log.info("createUpdateUser : " + user);
        if (user.getId() == null) {
            jdbcTemplate.update(INSERT_USER, user.getLogin(), user.getPassword(), user.getActive(), user.getEmail());
            var roles = user.getRoles();
            roles.forEach(role -> jdbcTemplate.update(INSERT_USER_ROLE, findByUsername(user.getLogin()).getId(),role.getAuthority()));
            log.info("register user : {}", user);
            return user;
        } else {
            jdbcTemplate.update(UPDATE_USER, user.getLogin(), user.getPassword(), user.getId());
            log.info("update user : {}", user);
            return getUser(user.getId());
        }

    }

    @Override
    public User findByUsername(String login) {
        var list = jdbcTemplate.query(GET_USER_BY_LOGIN, BeanPropertyRowMapper.newInstance(User.class), login);
        if (list.size() == 1) {
            log.info("found user : {}", list);
            return list.get(0);
        } else return null;
    }

    @Override
    public List<User> getAllUsers() {
        return jdbcTemplate.query(GET_ALL_USERS, BeanPropertyRowMapper.newInstance(User.class));
    }

}
