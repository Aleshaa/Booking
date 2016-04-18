package by.bsuir.booking.rest.dao;

import by.bsuir.booking.rest.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by User on 11.04.2016.
 */
public class CheckDaoImpl implements CheckDao {
    @Autowired
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;

    @Override
    public boolean addCheck(Check_r check) throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        session.save(check);
        tx.commit();
        session.close();

        return false;
    }

    @Override
    public boolean addChecks(List<Check_r> checks) throws Exception {
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
    public boolean updateCheck(Check_r check) throws Exception {
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
    public boolean updateChecks(List<Check_r> checks) throws Exception {
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
    public Check_r getCheckById(int id) throws Exception {
        session = sessionFactory.openSession();
        Check_r check_r = (Check_r) session.load(Check_r.class, new Integer(id));
        tx = session.getTransaction();
        session.beginTransaction();
        tx.commit();
        return check_r;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Check_r> getCheckList() throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        List<Check_r> checkRList = session.createCriteria(Check_r.class).list();
        tx.commit();
        session.close();
        return checkRList;
    }

    @Override
    public boolean deleteCheck(int id) throws Exception {
        session = sessionFactory.openSession();
        Object o = session.load(Check_r.class, id);
        tx = session.getTransaction();
        session.beginTransaction();
        session.delete(o);
        tx.commit();
        return false;
    }

    @Override
    public boolean deleteAllChecks() throws Exception {
        session = sessionFactory.openSession();
        tx = session.getTransaction();
        session.beginTransaction();
        session.createQuery("DELETE FROM Check_r").executeUpdate();
        tx.commit();
        return false;
    }
}
