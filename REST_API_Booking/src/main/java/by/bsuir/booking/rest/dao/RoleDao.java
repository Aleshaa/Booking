package by.bsuir.booking.rest.dao;

import by.bsuir.booking.rest.model.Role;

import java.util.List;

public interface RoleDao extends IDAO<Role> {
    public boolean add(Role role) throws Exception;
    public boolean addS(List<Role> roles) throws Exception;
    public boolean update(Role role) throws Exception;
    public boolean updateS(List<Role> roles) throws Exception;
    public Role getById(int id) throws Exception;
    public List<Role> getList() throws Exception;
    public boolean delete(int id) throws Exception;
    public boolean deleteAll() throws Exception;
}
