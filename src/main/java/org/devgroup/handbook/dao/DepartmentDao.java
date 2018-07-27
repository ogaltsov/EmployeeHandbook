package org.devgroup.handbook.dao;

import org.devgroup.handbook.entity.DepartmentEntity;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class DepartmentDao extends Dao<DepartmentEntity, Long> {

    @Override
    public List<DepartmentEntity> getAll() {
        return getCurrentSession().createQuery("from ???", DepartmentEntity.class).list();  //todo: replace ??? with name
    }

    @Override
    public DepartmentEntity getEntityById(Long id) {
        return getCurrentSession().get(DepartmentEntity.class, id);
    }

    @Override
    public void update(DepartmentEntity department) {
        getCurrentSession().update(department);
    }

    @Override
    public void delete(Long id) {
        DepartmentEntity department = getEntityById(id);
        getCurrentSession().delete(department);
    }

    @Override
    public void create(DepartmentEntity department) {
        getCurrentSession().save(department);
    }

    @Override
    List<DepartmentEntity> getWithCriteria(CriteriaQuery<DepartmentEntity> criteriaQuery) {
        return getCurrentSession().createQuery(criteriaQuery).list();
    }
}
