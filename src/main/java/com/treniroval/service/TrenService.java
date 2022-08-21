package com.treniroval.service;

import com.treniroval.entity.Approach;
import com.treniroval.entity.Exercise;
import com.treniroval.entity.Training;
import com.treniroval.entity.User;

import java.util.List;


public interface TrenService {

    List<Exercise> getExercises(Training training);

    List<Approach> getApproaches(Training training);

    List<Training> getTrains(User user);

    boolean createUser(User user);

    User getUser(int id);
}
