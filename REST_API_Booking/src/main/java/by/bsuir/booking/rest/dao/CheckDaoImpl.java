package by.bsuir.booking.rest.dao;

import by.bsuir.booking.rest.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CheckDaoImpl implements CheckDao {
    @Autowired
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;

    private static final CheckDaoImpl instance = new CheckDaoImpl();

    public CheckDaoImpl(){}

    public static CheckDaoImpl getInstance(){
        return instance;
    }

    @Override
    public boolean add(Check_r check) throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        session.save(check);
        tx.commit();
        session.close();

        return false;
    }

    @Override
    public boolean addS(List<Check_r> checks) throws Exception {
        session = sessionFactory.openSession();

        for(Check_r check_r:checks) {
            tx = session.beginTransaction();
            session.save(check_r);
            tx.commit();
        }
        session.close();

        return false;
    }

    @Override
    public boolean update(Check_r check) throws Exception {
        session = sessionFactory.openSession();
        Check_r check_r1;
        check_r1 = (Check_r) session.load(Check_r.class, check.getIdCheck());
        tx = session.getTransaction();
        check_r1 = check;
        tx = session.beginTransaction();
        session.saveOrUpdate(check_r1);
        tx.commit();
        session.close();
        return false;
    }

    @Override
    public boolean updateS(List<Check_r> checks) throws Exception {
        session = sessionFactory.openSession();
        for(Check_r check_r:checks) {
            Check_r check_r1;
            check_r1 = (Check_r) session.load(Check_r.class, check_r.getIdCheck());
            tx = session.getTransaction();
            check_r1 = check_r;
            tx = session.beginTransaction();
            session.saveOrUpdate(check_r1);
            tx.commit();
        }
        session.close();
        return false;
    }

    @Override
    public Check_r getById(int id) throws Exception {
        session = sessionFactory.openSession();
        Check_r check_r = (Check_r) session.load(Check_r.class, new Integer(id));
        tx = session.getTransaction();
        session.beginTransaction();
        tx.commit();
        return check_r;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Check_r> getList() throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        List<Check_r> checkRList = session.createCriteria(Check_r.class).list();
        tx.commit();
        session.close();
        return checkRList;
    }

    @Override
    public boolean delete(int id) throws Exception {
        session = sessionFactory.openSession();
        Object o = session.load(Check_r.class, id);
        tx = session.getTransaction();
        session.beginTransaction();
        session.delete(o);
        tx.commit();
        return false;
    }

    @Override
    public boolean deleteAll() throws Exception {
        session = sessionFactory.openSession();
        tx = session.getTransaction();
        session.beginTransaction();
        session.createQuery("DELETE FROM Check_r").executeUpdate();
        tx.commit();
        return false;
    }
}
