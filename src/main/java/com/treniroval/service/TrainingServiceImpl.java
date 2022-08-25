package com.treniroval.service;

import com.treniroval.dao.interfase.TrainingDAO;
import com.treniroval.entity.Training;
import com.treniroval.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TrainingServiceImpl implements TrainingService {

    private final TrainingDAO trainingDAO;

    public TrainingServiceImpl(TrainingDAO trainingDAO) {
        this.trainingDAO = trainingDAO;
    }

    @Override
    @Transactional
    public List<Training> getTrains(User user) {
        return trainingDAO.getTrains(user);
    }


}
