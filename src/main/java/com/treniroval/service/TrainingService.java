package com.treniroval.service;

import com.treniroval.entity.Training;
import com.treniroval.entity.User;

import java.util.List;


public interface TrainingService {

    List<Training> getTrains(User user);

    void createTraining(Training training);
}
