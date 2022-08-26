package com.treniroval.service;

import com.treniroval.entity.Approach;
import com.treniroval.entity.Training;

import java.util.List;

public interface ApproachService {

    List<Approach> getApproaches(Training training);

    void createApproach(Approach approach);
}
