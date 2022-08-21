package com.treniroval.service;

import com.treniroval.dao.interfase.ExerciseDAO;
import com.treniroval.entity.Exercise;
import com.treniroval.entity.Training;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TrenServiceImpl implements TrenService {

    @Autowired
    private ExerciseDAO exerciseDAO;

    @Override
    @Transactional
    public List<Exercise> getExercisesByTraining(Training training) {
        return exerciseDAO.getExercisesByTraining(training);
    }

}
