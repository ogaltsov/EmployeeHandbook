package org.devgroup.handbook.dao;

import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.List;

public interface GenericDao<E, K extends Serializable>  {
    List<E> getAll();

    E getEntityById(K id);

    void update(E entity);

    void delete(E entity);

    void create(E entity);

    <T> Query<T> getWithCriteria(CriteriaQuery<T> criteriaQuery);
}
