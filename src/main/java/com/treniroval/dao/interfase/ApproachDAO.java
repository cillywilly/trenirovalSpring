package com.treniroval.dao.interfase;

import com.treniroval.entity.Approach;
import com.treniroval.entity.Training;

import java.util.List;

public interface ApproachDAO {

    List<Approach> getApproaches(Training training);

    void createApproach(Approach approach);
}
