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
        return roleDao.add(role);
    }

    @Override
    public boolean addRoles(List<Role> roles) throws Exception {
        return roleDao.addS(roles);
    }

    @Override
    public boolean updateRole(Role role) throws Exception {
        return roleDao.update(role);
    }

    @Override
    public boolean updateRoles(List<Role> users) throws Exception {
        return roleDao.updateS(users);
    }

    @Override
    public Role getRoleById(int id) throws Exception {
        return roleDao.getById(id);
    }

    @Override
    public List<Role> getRoleList() throws Exception {
        return roleDao.getList();
    }

    @Override
    public boolean deleteRole(int id) throws Exception {
        return roleDao.delete(id);
    }

    @Override
    public boolean deleteAllRoles() throws Exception {
        return roleDao.deleteAll();
    }
}
