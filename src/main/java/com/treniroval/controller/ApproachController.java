package com.treniroval.controller;

import com.treniroval.entity.Approach;
import com.treniroval.entity.Training;
import com.treniroval.service.ApproachService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApproachController {

    private final ApproachService approachService;

    @PostMapping("/approaches")
    public List<Approach> getApproaches(@RequestBody Training training) {
        return approachService.getApproaches(training);
    }

    @PostMapping("/approach")
    public void createApproach(@RequestBody Approach approach, HttpServletRequest httpServletRequest) {
        httpServletRequest.setAttribute("TrainingId", approach.getTrainingId());
        httpServletRequest.getAttribute("TrainingId");
        approachService.createApproach(approach);
    }

    @DeleteMapping("/approach")
    public void deleteApproach(@RequestBody Approach approach) {
        approachService.deleteApproach(approach);
    }
}
