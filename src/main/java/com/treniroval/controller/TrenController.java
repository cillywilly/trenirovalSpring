package com.treniroval.controller;

import com.treniroval.entity.Exercise;
import com.treniroval.entity.Training;
import com.treniroval.service.TrenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TrenController {

    @Autowired
    private TrenService trenService;

    @GetMapping("/exercises")
    public List<Exercise> getExercisesByTraining() {
        Training training = new Training("Grudi", "1911-11-11 11:11:11", 1);
        List<Exercise> exercises = trenService.getExercisesByTraining(training);
         return exercises;
    }
}
