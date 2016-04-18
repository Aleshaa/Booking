package by.bsuir.booking.rest.services;

import by.bsuir.booking.rest.dao.RoleDao;
import by.bsuir.booking.rest.model.Role;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by User on 11.04.2016.
 */
public class RoleServicesImpl implements RoleServices {
    @Autowired
    RoleDao roleDao;

    @Override
    public boolean addRole(Role role) throws Exception {
        return roleDao.addRole(role);
    }

    @Override
    public boolean addRoles(List<Role> roles) throws Exception {
        return roleDao.addRoles(roles);
    }

    @Override
    public boolean updateRole(Role role) throws Exception {
        return roleDao.updateRole(role);
    }

    @Override
    public boolean updateRoles(List<Role> users) throws Exception {
        return roleDao.updateRoles(users);
    }

    @Override
    public Role getRoleById(int id) throws Exception {
        return roleDao.getRoleById(id);
    }

    @Override
    public List<Role> getRoleList() throws Exception {
        return roleDao.getRoleList();
    }

    @Override
    public boolean deleteRole(int id) throws Exception {
        return roleDao.deleteRole(id);
    }

    @Override
    public boolean deleteAllRoles() throws Exception {
        return roleDao.deleteAllRoles();
    }
}
