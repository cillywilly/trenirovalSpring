package com.treniroval.controller;

import com.treniroval.entity.Exercise;
import com.treniroval.entity.Training;
import com.treniroval.service.ExerciseService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ExerciseController {

    private final ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @PostMapping("/exercises")
    public List<Exercise> getExercises() {
        Training training = new Training("Hello trainig", "21.08.2022 19:54:00", 1);
        return exerciseService.getExercises(training);
    }

}
