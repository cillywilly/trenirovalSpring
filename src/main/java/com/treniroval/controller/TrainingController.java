package com.treniroval.controller;

import com.treniroval.entity.Training;
import com.treniroval.entity.User;
import com.treniroval.service.TrainingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TrainingController {

    private final TrainingService trainingService;

    public TrainingController(TrainingService trainingService) {
        this.trainingService = trainingService;
    }

    @PostMapping("/trains")
    public List<Training> getTrains(@RequestBody User user) {
        return trainingService.getTrains(user);
    }

    @PostMapping("/training")
    public void createTraining(@RequestBody Training training) {
        trainingService.createTraining(training);
    }

    @DeleteMapping("/training")
    public void deleteTraining(@RequestBody Training training) {
        trainingService.deleteTraining(training);
    }

    //updateTraining-> approaches
    //deleteTraining

}
