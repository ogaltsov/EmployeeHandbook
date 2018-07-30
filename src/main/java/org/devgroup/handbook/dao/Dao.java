package org.devgroup.handbook.dao;

import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
public abstract class Dao<E, K extends Serializable> {

    @Autowired
    private EntityManagerFactory entityManagerFactory;
    private SessionFactory sessionFactory;
    private Session currentSession;
    private Transaction currentTransaction;

    public Session openCurrentSession() {
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }

    public void closeCurrentSession() {
        currentSession.close();
    }

    private SessionFactory getSessionFactory() {
        sessionFactory = this.entityManagerFactory.unwrap(SessionFactory.class);
        return sessionFactory;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public Session getCurrentSession() {
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }


    abstract List<E> getAll();

    abstract E getEntityById(K id);

    abstract void update(E entity);

    abstract void delete(K id);

    abstract void create(E entity);

    abstract <T> Query<T> getWithCriteria(CriteriaQuery<T> criteriaQuery);
}
