package org.devgroup.handbook.dao;

import org.devgroup.handbook.entity.PositionEntity;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
public class PositionHibernateDao extends GenericHibernateDao<PositionEntity,Long> {

    /////
    //todo: realize dao methods
    /////



    @Override
    public List<PositionEntity> getAll() {
        return null;
    }

    @Override
    public PositionEntity getEntityById(Long id) {
        return getCurrentSession().get(PositionEntity.class, id);
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
    public <T> Query<T> getWithCriteria(CriteriaQuery<T> criteriaQuery) {
        return null;
    }
}
