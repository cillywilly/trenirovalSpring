package com.treniroval.service;

import com.treniroval.dao.interfase.ApproachDAO;
import com.treniroval.dao.interfase.ExerciseDAO;
import com.treniroval.dao.interfase.TrainingDAO;
import com.treniroval.dao.interfase.UserDAO;
import com.treniroval.entity.Approach;
import com.treniroval.entity.Exercise;
import com.treniroval.entity.Training;
import com.treniroval.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TrenServiceImpl implements TrenService {

    private final ExerciseDAO exerciseDAO;
    private final ApproachDAO approachDAO;
    private final TrainingDAO trainingDAO;
    private final UserDAO userDAO;

    public TrenServiceImpl(ExerciseDAO exerciseDAO
    , ApproachDAO approachDAO
    , TrainingDAO trainingDAO
    , UserDAO userDAO) {
        this.exerciseDAO = exerciseDAO;
        this.approachDAO = approachDAO;
        this.trainingDAO = trainingDAO;
        this.userDAO = userDAO;
    }

    @Override
    @Transactional
    public List<Exercise> getExercises(Training training) {
        return exerciseDAO.getExercises(training);
    }

    @Override
    @Transactional
    public List<Approach> getApproaches(Training training) {
        return approachDAO.getApproaches(training);
    }

    @Override
    @Transactional
    public List<Training> getTrains(User user) {
        return trainingDAO.getTrains(user);
    }

    @Override
    @Transactional
    public boolean createUser(User user) {
        return userDAO.createUser(user);
    }

    @Override
    @Transactional
    public User getUser(int id) {
        return userDAO.getUser(id);
    }

}
