package com.treniroval.dao;

import com.treniroval.dao.interfase.TrainingDAO;
import com.treniroval.entity.Training;
import com.treniroval.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class TrainingDAOImpl implements TrainingDAO {

    private final EntityManager entityManager;

    public TrainingDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Training> getTrains(User user) {
        //todo
        Query query = entityManager.createQuery("from Training where idUser=1");
        return query.getResultList();
    }
}
