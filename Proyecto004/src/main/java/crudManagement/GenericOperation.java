package crudManagement;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class GenericOperation<T> implements IDAO_Crud<T> {
    private Session session;
    private Transaction transaction;
    private Class<T> type;

    public GenericOperation(Class<T> type) {
        this.type = type;
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml"); 
        session = cfg.buildSessionFactory().openSession();
    }

    public void startTransaction() {
        transaction = session.beginTransaction();
    }

    public void commitTransaction() {
        transaction.commit();
    }

    @Override
    public void create(T entity) {
        startTransaction();
        session.persist(entity);
        commitTransaction();
    }

    @Override
    public T read(int id) {
        return session.get(type, id);
    }

    @Override
    public void update(T entity) {
        startTransaction();
        session.update(entity);
        commitTransaction();
    }

    @Override
    public void delete(T entity) {
        startTransaction();
        session.delete(entity);
        commitTransaction();
    }

    public void close() {
        session.close();
    }
}

