package com.treniroval.dao;

import com.treniroval.entity.Exercise;
import com.treniroval.entity.Training;

import java.util.List;

public interface ExerciseDAO {

    List<Exercise> getExercisesByTraining(Training training);

}
