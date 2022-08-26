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
    private static final String CREATE_APPROACH = "INSERT INTO Approach (training_id, exercise_id, approach_number, repeat, workload) values (?, ?, ?, ?, ?)";

    @Override
    public List<Approach> getApproaches(Training training) {
//todo        return jdbcTemplate.query(GET_APPROACHES_BY_TRAINING, BeanPropertyRowMapper.newInstance(Approach.class), training.getId());
        return jdbcTemplate.query(GET_APPROACHES_BY_TRAINING, BeanPropertyRowMapper.newInstance(Approach.class),1);
    }

    @Override
    public void createApproach(Approach approach) {
        jdbcTemplate.update(CREATE_APPROACH
                , approach.getTrainingId()
                , approach.getExerciseId()
                , approach.getApproachNumber()
                , approach.getRepeat()
                , approach.getWorkload()
                );
    }
}
