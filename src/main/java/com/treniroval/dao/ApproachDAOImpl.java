package com.treniroval.dao;

import com.treniroval.dao.interfase.ApproachDAO;
import com.treniroval.entity.Approach;
import com.treniroval.entity.Training;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class ApproachDAOImpl implements ApproachDAO {

    private final EntityManager entityManager;

    public ApproachDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Approach> getApproaches(Training training) {
        //todo
        Query query = entityManager.createQuery("from Approach where idTraining=1");
        return query.getResultList();
    }
}
