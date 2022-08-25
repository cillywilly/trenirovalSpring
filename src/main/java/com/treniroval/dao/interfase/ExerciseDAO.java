package com.treniroval.dao.interfase;

import com.treniroval.entity.Exercise;
import com.treniroval.entity.Training;

import java.util.List;

public interface ExerciseDAO {

    List<Exercise> getExercises(Training training);

    void createExercise(Exercise exercise);
}
