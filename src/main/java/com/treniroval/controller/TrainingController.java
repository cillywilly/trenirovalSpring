package com.treniroval.controller;

import com.treniroval.entity.Approach;
import com.treniroval.entity.Training;
import com.treniroval.entity.User;
import com.treniroval.service.ApproachService;
import com.treniroval.service.ExerciseService;
import com.treniroval.service.TrainingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("/api")
@RequiredArgsConstructor
public class TrainingController {

    private final TrainingService trainingService;
    private final ApproachService approachService;
    private final ExerciseService exerciseService;
    private final UserController userController;

    @PostMapping("/trains")
    public List<Training> getTrains(@RequestBody User user) {
        return trainingService.getTrains(user);
    }

    @PostMapping(value = "/training", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public String createTraining(@RequestParam MultiValueMap<String, String> training) {
        var mappedTraining = new Training(training.get("trainingTopic").get(0)
                , training.get("date").get(0)
                , Long.valueOf(training.get("userId").get(0)));
        trainingService.createTraining(mappedTraining);
        return "redirect:/main";
    }

    @GetMapping(value = "/training"
            , consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public String getTraining(Model model, @RequestParam Long id, MultiValueMap<String, String> map) {
        Training training = trainingService.getTraining(id);
        List<Approach> approaches = approachService.getApproaches(training);
        approaches.sort(Comparator.comparing(Approach::getId));
        User user = userController.getCurrentUser();
        model.addAttribute("approaches", approaches);
        model.addAttribute("user", user);
        model.addAttribute("training", training);
        return "training";
    }

    @DeleteMapping("/training")
    public void deleteTraining(@RequestBody Training training) {
        trainingService.deleteTraining(training);
    }

}
