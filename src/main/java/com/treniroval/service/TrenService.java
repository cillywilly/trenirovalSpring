package com.treniroval.service;

import com.treniroval.entity.Exercise;
import com.treniroval.entity.Training;

import java.util.List;


public interface TrenService {

    List<Exercise> getExercisesByTraining(Training training);

}
