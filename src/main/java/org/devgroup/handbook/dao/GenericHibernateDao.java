package org.devgroup.handbook.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.io.Serializable;

public abstract class GenericHibernateDao<E, K extends Serializable> implements GenericDao<E, K>{
    @Autowired
    private EntityManager entityManager;

    static private Session currentSession;
    private Transaction currentTransaction;

    public Session openSession() {
        currentSession = (Session) entityManager.getDelegate();
        System.out.println(currentSession);///////////////////////////////////////////////////
        return currentSession;
    }

    public void closeSession() {
        currentSession.close();
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
        if(currentSession==null)
            currentSession = openSession();
        return currentSession;
    }
}
