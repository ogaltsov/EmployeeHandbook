package org.devgroup.handbook.dao;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.List;

public interface EntityDao<E, K extends Serializable>  {
    List<E> getAll();

    E getEntityById(K id);

    void update(E entity);

    void delete(E entity);

    void create(E entity);

    <T> TypedQuery<T> getWithCriteria(CriteriaQuery<T> criteriaQuery);
}
