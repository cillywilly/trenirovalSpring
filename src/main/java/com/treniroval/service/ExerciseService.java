package com.treniroval.service;

import com.treniroval.entity.Exercise;
import com.treniroval.entity.Training;

import java.util.List;

public interface ExerciseService {
    List<Exercise> getExercises();

    void createExercise(Exercise exercise);

    List<Exercise> getExercisesByTraining(Training training);
}
