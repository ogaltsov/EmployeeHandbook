package org.devgroup.handbook.dao;

import org.devgroup.handbook.entity.EmployeeEntity;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
public class EmployeeDao implements EntityDao<EmployeeEntity, Long> {

    private final EntityManager entityManager;

    @Autowired
    public EmployeeDao(EntityManager entityManager) {
        this.entityManager=entityManager;
    }



    @Override
    public List<EmployeeEntity> getAll() {
        return entityManager.createQuery("from EmployeeEntity", EmployeeEntity.class).getResultList();
    }

    @Override
    public EmployeeEntity getEntityById(Long id) {
        return entityManager.find(EmployeeEntity.class, id);
    }

    @Override
    public void update(EmployeeEntity employee) {
        entityManager.merge(employee);
        entityManager.flush();
    }

    @Override
    public void delete(EmployeeEntity employee) {
        EmployeeEntity employeeEntity = entityManager.getReference(EmployeeEntity.class, employee.getId());
        entityManager.remove(employeeEntity);
        entityManager.flush();
    }

    @Override
    public Long create(EmployeeEntity employee) {
        entityManager.persist(employee);
        return employee.getId();
    }

    @Override
    public <T> TypedQuery<T> getWithCriteria(CriteriaQuery<T> criteriaQuery) {
        return entityManager.createQuery(criteriaQuery);
    }
}
