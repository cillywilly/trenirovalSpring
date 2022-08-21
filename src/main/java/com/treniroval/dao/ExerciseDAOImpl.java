package com.treniroval.dao;

import com.treniroval.dao.interfase.ExerciseDAO;
import com.treniroval.entity.Exercise;
import com.treniroval.entity.Training;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;


@Repository
public class ExerciseDAOImpl implements ExerciseDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Exercise> getExercisesByTraining(Training training) {
        Session session = entityManager.unwrap(Session.class);
        Query<Exercise> query = session.createQuery("from Exercise"
                , Exercise.class);
        List<Exercise> exer = new ArrayList<>();
        exer.add(new Exercise("Grudi"));
        session.close();
        return exer;
    }
}
