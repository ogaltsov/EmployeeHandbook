package org.devgroup.handbook.dao;

import org.devgroup.handbook.entity.DepartmentEntity;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
public class DepartmentDao extends Dao<DepartmentEntity, Long> {

    @Override
    public List<DepartmentEntity> getAll() {
        return getCurrentSession().createQuery("from DepartmentEntity", DepartmentEntity.class).list();
    }

    @Override
    public DepartmentEntity getEntityById(Long id) {
        return getCurrentSession().get(DepartmentEntity.class, id);
    }

    @Override
    @Transactional
    public void update(DepartmentEntity department) {
        getCurrentSession().update(department);
    }

    @Override
    @Transactional
    public void delete(DepartmentEntity department) {
        getCurrentSession().delete(department);
    }

    @Override
    @Transactional
    public void create(DepartmentEntity department) {
        getCurrentSession().save(department);
    }

    @Override
    public <T> Query<T> getWithCriteria(CriteriaQuery<T> criteriaQuery) {
        return getCurrentSession().createQuery(criteriaQuery);
    }
}
