package com.treniroval.dao.interfase;

import com.treniroval.entity.Exercise;
import com.treniroval.entity.Training;

import java.util.List;

public interface ExerciseDAO {

    List<Exercise> getExercisesByTraining(Training training);

    void createExercise(Exercise exercise);

    void updateExercise(Exercise exercise);

    List<Exercise> getAllExercises();
}
