package com.treniroval.controller;

import com.treniroval.entity.Approach;
import com.treniroval.entity.Exercise;
import com.treniroval.entity.Training;
import com.treniroval.entity.User;
import com.treniroval.service.TrenService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TrenController {

    private final TrenService trenService;

    public TrenController(TrenService trenService) {
        this.trenService = trenService;
    }

    @PostMapping("/exercises")
    public List<Exercise> getExercises() {
        Training training = new Training("Hello trainig", "21.08.2022 19:54:00", 1);
        return trenService.getExercises(training);
    }

    @PostMapping("/allApproaches")
    public List<Approach> getApproaches() {
        Training training = new Training("Hello trainig", "21.08.2022 19:54:00", 1);
        return trenService.getApproaches(training);
    }

    @PostMapping("/trains")
    public List<Training> getTrains() {
        return trenService.getTrains(new User("admin", "admin"));
    }

    @PostMapping("/user")
    public void createUser() {
        trenService.createUser(new User("admin", "admin"));
    }

    @GetMapping("/user")
    public User getUser() {
        return trenService.getUser(1);
    }

}
