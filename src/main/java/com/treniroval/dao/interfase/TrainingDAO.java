package com.treniroval.dao.interfase;

import com.treniroval.entity.Training;
import com.treniroval.entity.User;

import java.util.List;

public interface TrainingDAO {
    List<Training> getTrains(User user);
}
