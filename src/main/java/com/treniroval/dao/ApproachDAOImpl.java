package com.treniroval.dao;

import com.treniroval.dao.interfase.ApproachDAO;
import com.treniroval.entity.Approach;
import com.treniroval.entity.Training;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ApproachDAOImpl implements ApproachDAO {

    private final JdbcTemplate jdbcTemplate;

    private static final String GET_APPROACHES_BY_TRAINING = "SELECT * FROM APPROACH WHERE TRAINING_ID = ?";
    private static final String CREATE_APPROACH = "INSERT INTO treniroval.APPROACH (TRAINING_ID, EXERCISE_ID, APPROACH_NUMBER, repetitions_number, WORKLOAD) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE_APPROACH = "UPDATE treniroval.APPROACH SET TRAINING_ID = ?, EXERCISE_ID = ?, APPROACH_NUMBER = ?, repetitions_number = ?, WORKLOAD = ? WHERE ID = ?";
    private static final String DELETE_APPROACH = "DELETE FROM treniroval.APPROACH WHERE ID = ?";

    @Override
    public List<Approach> getApproaches(Training training) {
        return jdbcTemplate.query(GET_APPROACHES_BY_TRAINING, BeanPropertyRowMapper.newInstance(Approach.class), training.getId());
    }

    @Override
    public void createApproach(Approach approach) {
        if (approach.getId() == null) {
            jdbcTemplate.update(CREATE_APPROACH
                    , approach.getTrainingId()
                    , approach.getExerciseId()
                    , approach.getApproachNumber()
                    , approach.getRepetitions_number()
                    , approach.getWorkload()
            );
        } else {
            jdbcTemplate.update(UPDATE_APPROACH
                    , approach.getTrainingId()
                    , approach.getExerciseId()
                    , approach.getApproachNumber()
                    , approach.getRepetitions_number()
                    , approach.getWorkload()
                    , approach.getId()
            );
        }

    }

    @Override
    public void deleteApproach(Approach approach) {
        jdbcTemplate.update(DELETE_APPROACH, approach.getId());
    }
}
