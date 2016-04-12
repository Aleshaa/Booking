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
        return false;
    }

    @Override
    public boolean addChecks(List<Check_r> checks) throws Exception {
        return false;
    }

    @Override
    public boolean updateCheck(Check_r check) throws Exception {
        return false;
    }

    @Override
    public boolean updateChecks(List<Check_r> checks) throws Exception {
        return false;
    }

    @Override
    public Check_r getCheckById(int id) throws Exception {
        return null;
    }

    @Override
    public List<Check_r> getCheckList() throws Exception {
        return null;
    }

    @Override
    public boolean deleteCheck(int id) throws Exception {
        return false;
    }

    @Override
    public boolean deleteAllChecks() throws Exception {
        return false;
    }
}
