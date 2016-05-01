package by.bsuir.booking.rest.dao;

import by.bsuir.booking.rest.model.*;

import java.util.List;

public interface CheckDao {

    public boolean addCheck(Check_r check) throws Exception;
    public boolean addChecks(List<Check_r> checks) throws Exception;
    public boolean updateCheck(Check_r check) throws Exception;
    public boolean updateChecks(List<Check_r> checks) throws Exception;
    public Check_r getCheckById(int id) throws Exception;
    public List<Check_r> getCheckList() throws Exception;
    public boolean deleteCheck(int id) throws Exception;
    public boolean deleteAllChecks() throws Exception;

}
