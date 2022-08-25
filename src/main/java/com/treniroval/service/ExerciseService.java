package com.treniroval.service;

import com.treniroval.entity.Exercise;
import com.treniroval.entity.Training;

import java.util.List;

public interface ExerciseService {
    List<Exercise> getExercises(Training training);

    void createExercise(Exercise exercise);
}
