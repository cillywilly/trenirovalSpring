package com.treniroval.service;

import com.treniroval.dao.interfase.ExerciseDAO;
import com.treniroval.entity.Exercise;
import com.treniroval.entity.Training;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ExerciseServiceImpl implements ExerciseService {

    private final ExerciseDAO exerciseDAO;

    public ExerciseServiceImpl(ExerciseDAO exerciseDAO) {
        this.exerciseDAO = exerciseDAO;
    }

    @Override
    @Transactional
    public List<Exercise> getExercises(Training training) {
        return exerciseDAO.getExercises(training);
    }
}
