package com.treniroval.controller;

import com.treniroval.entity.Training;
import com.treniroval.entity.User;
import com.treniroval.service.TrainingService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TrainingController {

    private final TrainingService trainingService;

    public TrainingController(TrainingService trenService) {
        this.trainingService = trenService;
    }

    @PostMapping("/trains")
    public List<Training> getTrains() {
        return trainingService.getTrains(new User("admin", "admin"));
    }


}
