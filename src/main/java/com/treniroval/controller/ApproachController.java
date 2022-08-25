package com.treniroval.controller;

import com.treniroval.entity.Approach;
import com.treniroval.entity.Training;
import com.treniroval.service.ApproachService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApproachController {

    private final ApproachService approachService;

    public ApproachController(ApproachService approachService) {
        this.approachService = approachService;
    }

    @PostMapping("/approaches")
    public List<Approach> getApproaches(@RequestBody Training training) {
        return approachService.getApproaches(training);
    }


}
