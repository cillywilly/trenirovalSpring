package com.treniroval.service;

import com.treniroval.entity.Exercise;

import java.util.List;

public interface ExerciseService {
    List<Exercise> getExercises();

    void createExercise(Exercise exercise);
}
