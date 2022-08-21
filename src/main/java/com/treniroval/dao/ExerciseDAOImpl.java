package com.treniroval.dao;

import com.treniroval.dao.interfase.ExerciseDAO;
import com.treniroval.entity.Exercise;
import com.treniroval.entity.Training;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;


@Repository
public class ExerciseDAOImpl implements ExerciseDAO {

    private final EntityManager entityManager;

    public ExerciseDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Exercise> getExercises(Training training) {
        return entityManager.createQuery("from Exercise").getResultList();
    }
}
