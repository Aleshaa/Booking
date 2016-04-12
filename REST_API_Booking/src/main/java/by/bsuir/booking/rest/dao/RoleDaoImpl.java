package by.bsuir.booking.rest.dao;

import by.bsuir.booking.rest.model.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by User on 11.04.2016.
 */
public class RoleDaoImpl implements RoleDao{

    @Autowired
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;

    @Override
    public boolean addRole(Role role) throws Exception {
        return false;
    }

    @Override
    public boolean addRoles(List<Role> roles) throws Exception {
        return false;
    }

    @Override
    public boolean updateRole(Role role) throws Exception {
        return false;
    }

    @Override
    public boolean updateRoles(List<Role> users) throws Exception {
        return false;
    }

    @Override
    public Role getRoleById(int id) throws Exception {
        return null;
    }

    @Override
    public List<Role> getRoleList() throws Exception {
        return null;
    }

    @Override
    public boolean deleteRole(int id) throws Exception {
        return false;
    }

    @Override
    public boolean deleteAllRoles() throws Exception {
        return false;
    }


}
