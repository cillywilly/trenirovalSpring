package com.treniroval.controller;

import com.treniroval.entity.Exercise;
import com.treniroval.entity.Training;
import com.treniroval.service.ExerciseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ExerciseController {

    private final ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @GetMapping("/exercises")
    public List<Exercise> getExercises() {
        return exerciseService.getExercises();
    }

    @PostMapping("/exercises")//udoli
    public List<Exercise> getExercisesByTraining(Training training) {
        return exerciseService.getExercisesByTraining(training);
    }

    @PostMapping("/exercise")
    public void createExercise(@RequestBody Exercise exercise) {
        exerciseService.createExercise(exercise);
    }
}
