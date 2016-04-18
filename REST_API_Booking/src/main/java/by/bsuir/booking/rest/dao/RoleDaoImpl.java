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
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        session.save(role);
        tx.commit();
        session.close();

        return false;
    }

    @Override
    public boolean addRoles(List<Role> roles) throws Exception {
        session = sessionFactory.openSession();

        for(Role role:roles) {
            tx = session.beginTransaction();
            session.save(role);
            tx.commit();
        }
        session.close();

        return false;
    }

    @Override
    public boolean updateRole(Role role) throws Exception {
        session = sessionFactory.openSession();
        Role role1;
        role1 = (Role) session.load(Role.class, role.getIdRole());
        tx = session.getTransaction();
        role1 = role;
        tx = session.beginTransaction();
        session.saveOrUpdate(role1);
        tx.commit();
        session.close();
        return false;
    }

    @Override
    public boolean updateRoles(List<Role> roles) throws Exception {
        session = sessionFactory.openSession();
        for(Role role:roles) {
            Role user1;
            user1 = (Role) session.load(Role.class, role.getIdRole());
            tx = session.getTransaction();
            user1 = role;
            tx = session.beginTransaction();
            session.saveOrUpdate(user1);
            tx.commit();
        }
        session.close();
        return false;
    }

    @Override
    public Role getRoleById(int id) throws Exception {
        session = sessionFactory.openSession();
        Role role = (Role) session.load(Role.class, new Integer(id));
        tx = session.getTransaction();
        session.beginTransaction();
        tx.commit();
        return role;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Role> getRoleList() throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        List<Role> roleList = session.createCriteria(Role.class).list();
        tx.commit();
        session.close();
        return roleList;
    }

    @Override
    public boolean deleteRole(int id) throws Exception {
        session = sessionFactory.openSession();
        Object o = session.load(Role.class, id);
        tx = session.getTransaction();
        session.beginTransaction();
        session.delete(o);
        tx.commit();
        return false;
    }

    @Override
    public boolean deleteAllRoles() throws Exception {
        session = sessionFactory.openSession();
        tx = session.getTransaction();
        session.beginTransaction();
        session.createQuery("DELETE FROM Role").executeUpdate();
        tx.commit();
        return false;
    }


}
