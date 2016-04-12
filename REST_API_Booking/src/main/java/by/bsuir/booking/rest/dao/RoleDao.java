package by.bsuir.booking.rest.dao;

import by.bsuir.booking.rest.model.Role;

import java.util.List;

/**
 * Created by User on 11.04.2016.
 */
public interface RoleDao {
    public boolean addRole(Role role) throws Exception;
    public boolean addRoles(List<Role> roles) throws Exception;
    public boolean updateRole(Role role) throws Exception;
    public boolean updateRoles(List<Role> users) throws Exception;
    public Role getRoleById(int id) throws Exception;
    public List<Role> getRoleList() throws Exception;
    public boolean deleteRole(int id) throws Exception;
    public boolean deleteAllRoles() throws Exception;
}
