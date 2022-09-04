package com.treniroval.dao;

import com.treniroval.dao.interfase.ExerciseDAO;
import com.treniroval.entity.Exercise;
import com.treniroval.entity.Training;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@RequiredArgsConstructor
public class ExerciseDAOImpl implements ExerciseDAO {

    private final JdbcTemplate jdbcTemplate;

    private static final String GET_ALL_EXERCISES = "SELECT * FROM EXERCISE";
    private static final String INSERT_EXERCISE = "INSERT into exercise (EXERCISE_NAME) VALUES (?)";
    private static final String UPDATE_EXERCISE = "UPDATE 'EXERCISE' SET EXERCISE_NAME = ? WHERE id = ?";

    @Override
    public List<Exercise> getExercises(Training training) {
        return jdbcTemplate.query(GET_ALL_EXERCISES, BeanPropertyRowMapper.newInstance(Exercise.class));
    }

    @Override
    public void createUpdateExercise(Exercise exercise) {
        if (exercise.getId() == 0) {
            jdbcTemplate.update(UPDATE_EXERCISE, exercise.getExerciseName(), exercise.getId());
        } else {
            jdbcTemplate.update(INSERT_EXERCISE, exercise.getExerciseName());
        }
    }
}
