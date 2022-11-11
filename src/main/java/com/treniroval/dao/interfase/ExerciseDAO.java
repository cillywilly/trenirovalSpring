package com.treniroval.dao.interfase;

import com.treniroval.entity.Exercise;

import java.util.List;

public interface ExerciseDAO {

    List<Exercise> getExercises();

    void createUpdateExercise(Exercise exercise);
}
