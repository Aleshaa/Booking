package by.bsuir.booking.rest.dao;

import by.bsuir.booking.rest.model.*;

import java.util.List;

public interface CheckDao extends IDAO<Check_r> {

    public boolean add(Check_r check) throws Exception;
    public boolean addS(List<Check_r> checks) throws Exception;
    public boolean update(Check_r check) throws Exception;
    public boolean updateS(List<Check_r> checks) throws Exception;
    public Check_r getById(int id) throws Exception;
    public List<Check_r> getList() throws Exception;
    public boolean delete(int id) throws Exception;
    public boolean deleteAll() throws Exception;

}
