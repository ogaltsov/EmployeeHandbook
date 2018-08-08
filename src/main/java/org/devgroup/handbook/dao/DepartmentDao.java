package org.devgroup.handbook.dao;

import org.devgroup.handbook.entity.DepartmentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
public class DepartmentDao implements EntityDao<DepartmentEntity, Long> {

    private final EntityManager entityManager;

    @Autowired
    public DepartmentDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<DepartmentEntity> getAll() {
        return entityManager.createQuery("from DepartmentEntity", DepartmentEntity.class).getResultList();
    }

    @Override
    public DepartmentEntity getEntityById(Long id) {
        return entityManager.find(DepartmentEntity.class, id);
    }

    @Override
    @Transactional
    public void update(DepartmentEntity department) {
        entityManager.merge(department);
        entityManager.flush();
    }

    @Override
    @Transactional
    public void delete(DepartmentEntity department) {
        DepartmentEntity departmentEntity = entityManager.getReference(DepartmentEntity.class, department.getId());
        entityManager.remove(departmentEntity);
        entityManager.flush();

    }

    @Override
    @Transactional
    public Long create(DepartmentEntity department) {
        entityManager.persist(department);
        return department.getId();
    }

    @Override
    public <T> TypedQuery<T> getWithCriteria(CriteriaQuery<T> criteriaQuery) {
        return entityManager.createQuery(criteriaQuery);
    }
}
