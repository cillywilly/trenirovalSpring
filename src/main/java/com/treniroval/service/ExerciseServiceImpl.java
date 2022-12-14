package com.treniroval.service;

import com.treniroval.dao.interfase.ExerciseDAO;
import com.treniroval.entity.Exercise;
import com.treniroval.entity.Training;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExerciseServiceImpl implements ExerciseService {

    private final ExerciseDAO exerciseDAO;

    @Override
    @Transactional
    public List<Exercise> getExercises() {
        return exerciseDAO.getAllExercises();
    }

    @Override
    public void createExercise(Exercise exercise) {
        exerciseDAO.createExercise(exercise);
    }

    @Override
    public List<Exercise> getExercisesByTraining(Training training) {
        return exerciseDAO.getExercisesByTraining(training);
    }
}
