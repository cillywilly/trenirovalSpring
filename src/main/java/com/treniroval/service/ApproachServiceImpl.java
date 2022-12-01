package com.treniroval.service;

import com.treniroval.dao.interfase.ApproachDAO;
import com.treniroval.entity.Approach;
import com.treniroval.entity.Training;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApproachServiceImpl implements ApproachService {

   private final ApproachDAO approachDAO;

    @Override
    @Transactional
    public List<Approach> getApproaches(Training training) {
        return approachDAO.getApproaches(training);
    }

    @Override
    public void createApproach(Approach approach) {
        approachDAO.createApproach(approach);
    }

    @Override
    public void deleteApproach(Approach approach) {
        approachDAO.deleteApproach(approach);
    }

}
