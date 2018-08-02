package org.devgroup.handbook.dao;

import org.devgroup.handbook.entity.EmployeeEntity;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;


import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
public class EmployeeHibernateDao extends GenericHibernateDao<EmployeeEntity, Long> {

    @Override
    public List<EmployeeEntity> getAll() {
        return getCurrentSession().createQuery("from EmployeeEntity", EmployeeEntity.class).list();
    }

    @Override
    public EmployeeEntity getEntityById(Long id) {
        return getCurrentSession().get(EmployeeEntity.class, id);
    }

    @Override
    public void update(EmployeeEntity entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public void delete(EmployeeEntity employee) {
        getCurrentSession().delete(employee);
    }

    @Override
    public void create(EmployeeEntity employee) {
        getCurrentSession().save(employee);
    }

    @Override
    public <T> Query<T> getWithCriteria(CriteriaQuery<T> criteriaQuery) {
        return getCurrentSession().createQuery(criteriaQuery);
    }
}
