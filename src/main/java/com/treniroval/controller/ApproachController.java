package com.treniroval.controller;

import com.treniroval.entity.Approach;
import com.treniroval.entity.Training;
import com.treniroval.service.ApproachService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/")
    public void createApproach(@RequestBody Approach approach) {
        approachService.createApproach(approach);
    }

}
