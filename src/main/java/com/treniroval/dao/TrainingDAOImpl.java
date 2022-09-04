package com.treniroval.dao;

import com.treniroval.dao.interfase.TrainingDAO;
import com.treniroval.entity.Training;
import com.treniroval.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TrainingDAOImpl implements TrainingDAO {

    private final JdbcTemplate jdbcTemplate;

    private static final String GET_TRAINING_BY_USER = "SELECT * FROM Training where USER_ID = ?";
    private static final String CREATE_TRAINING = "INSERT INTO Training (TRAINING_TOPIC, DATE, USER_ID) values (?, ?, ?)";
    private static final String UPDATE_TRAINING = "UPDATE Training set TRAINING_TOPIC = ?, DATE = ?, USER_ID = ? WHERE ID = ?";
    private static final String DELETE_TRAINING = "DELETE FROM Training WHERE ID= ?";

    @Override
    public List<Training> getTrains(User user) {
        return jdbcTemplate.query(GET_TRAINING_BY_USER, BeanPropertyRowMapper.newInstance(Training.class), user.getId());
    }

    @Override
    public void createUpdateTraining(Training training) {
        if (training.getId() == 0) {
            jdbcTemplate.update(CREATE_TRAINING, training.getTrainingTopic(), training.getDate(), training.getUserId());
        } else {
            jdbcTemplate.update(UPDATE_TRAINING, training.getTrainingTopic(), training.getDate(), training.getUserId(), training.getId());

        }
    }

    @Override
    public void deleteTraining(Training training) {
        jdbcTemplate.update(DELETE_TRAINING, training.getId());
    }

}
