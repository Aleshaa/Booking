package by.bsuir.booking.rest.services;

import by.bsuir.booking.rest.dao.CheckDao;
import by.bsuir.booking.rest.model.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CheckServicesImpl implements CheckServices{

    @Autowired
    CheckDao checkDao;

    @Override
    public boolean addCheck(Check_r check) throws Exception {
        return checkDao.add(check);
    }

    @Override
    public boolean addChecks(List<Check_r> checks) throws Exception {
        return checkDao.addS(checks);
    }

    @Override
    public boolean updateCheck(Check_r check) throws Exception {
        return checkDao.update(check);
    }

    @Override
    public boolean updateChecks(List<Check_r> checks) throws Exception {
        return checkDao.updateS(checks);
    }

    @Override
    public Check_r getCheckById(int id) throws Exception {
        return checkDao.getById(id);
    }

    @Override
    public List<Check_r> getCheckList() throws Exception {
        return checkDao.getList();
    }

    @Override
    public boolean deleteCheck(int id) throws Exception {
        return checkDao.delete(id);
    }

    @Override
    public boolean deleteAllChecks() throws Exception {
        return checkDao.deleteAll();
    }
}
