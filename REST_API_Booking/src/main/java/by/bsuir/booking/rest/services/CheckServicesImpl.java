package by.bsuir.booking.rest.services;

import by.bsuir.booking.rest.dao.CheckDao;
import by.bsuir.booking.rest.model.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by User on 11.04.2016.
 */
public class CheckServicesImpl implements CheckServices{

    @Autowired
    CheckDao checkDao;

    @Override
    public boolean addCheck(Check_r check) throws Exception {
        return checkDao.addCheck(check);
    }

    @Override
    public boolean addChecks(List<Check_r> checks) throws Exception {
        return checkDao.addChecks(checks);
    }

    @Override
    public boolean updateCheck(Check_r check) throws Exception {
        return checkDao.updateCheck(check);
    }

    @Override
    public boolean updateChecks(List<Check_r> checks) throws Exception {
        return checkDao.updateChecks(checks);
    }

    @Override
    public Check_r getCheckById(int id) throws Exception {
        return checkDao.getCheckById(id);
    }

    @Override
    public List<Check_r> getCheckList() throws Exception {
        return checkDao.getCheckList();
    }

    @Override
    public boolean deleteCheck(int id) throws Exception {
        return checkDao.deleteCheck(id);
    }

    @Override
    public boolean deleteAllChecks() throws Exception {
        return checkDao.deleteAllChecks();
    }
}
