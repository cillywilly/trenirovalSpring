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

    private static final String GET_TRAINING_BY_USER = "from Training where idUser = ?";
    private static final String CREATE_TRAINING = "INSERT INTO Training (trainingTopic, 'date', userId) values (?, ?, ?)";

    @Override
    public List<Training> getTrains(User user) {
        return jdbcTemplate.query(GET_TRAINING_BY_USER, BeanPropertyRowMapper.newInstance(Training.class), user.getId());
    }

    @Override
    public void createTraining(Training training) {
        jdbcTemplate.update(CREATE_TRAINING, training.getTrainingTopic(), training.getDate(), training.getUserId());

    }
}
