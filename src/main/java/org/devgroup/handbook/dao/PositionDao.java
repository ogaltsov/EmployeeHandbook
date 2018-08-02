package org.devgroup.handbook.dao;

import org.devgroup.handbook.entity.PositionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
public class PositionDao implements EntityDao<PositionEntity,Long> {

    /////
    //todo: realize dao methods
    /////

    private final EntityManager entityManager;

    @Autowired
    public PositionDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }


    @Override
    public List<PositionEntity> getAll() {
        return null;
    }

    @Override
    public PositionEntity getEntityById(Long id) {
        return entityManager.find(PositionEntity.class, id);
    }

    @Override
    public void update(PositionEntity entity) {

    }

    @Override
    public void delete(PositionEntity position) {

    }

    @Override
    public void create(PositionEntity entity) {

    }

    @Override
    public <T> TypedQuery<T> getWithCriteria(CriteriaQuery<T> criteriaQuery) {
        return null;
    }
}
