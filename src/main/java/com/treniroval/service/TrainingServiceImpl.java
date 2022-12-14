package com.treniroval.service;

import com.treniroval.dao.interfase.TrainingDAO;
import com.treniroval.entity.Training;
import com.treniroval.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrainingServiceImpl implements TrainingService {

    private final TrainingDAO trainingDAO;

    @Override
    @Transactional
    public List<Training> getTrains(User user) {
        return trainingDAO.getTrains(user);
    }

    @Override
    public void createTraining(Training training) {
        trainingDAO.createUpdateTraining(training);
    }

    @Override
    public void deleteTraining(Training training) {
        trainingDAO.deleteTraining(training);
    }

    @Override
    public Training getTraining(Long id) {
        return trainingDAO.getTraining(id);
    }


}
