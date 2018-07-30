package org.devgroup.handbook.dao;

import org.devgroup.handbook.entity.EmployeeEntity;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
public class EmployeeDao extends Dao<EmployeeEntity, Long> {

    @Override
    public List<EmployeeEntity> getAll() {
        return getCurrentSession().createQuery("from ???", EmployeeEntity.class).list();  //todo: replace ??? with name
    }

    @Override
    public EmployeeEntity getEntityById(Long id) {
        return getCurrentSession().get(EmployeeEntity.class, id);
    }

    @Override
    public void update(EmployeeEntity entity) {
        /////////////////////////////
        System.out.println(entity.getGrade());
        System.out.println(getCurrentSession() + " current session");

        getCurrentSession().update(entity);
    }

    @Override
    public void delete(Long id) {
        EmployeeEntity employee = getEntityById(id);
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
