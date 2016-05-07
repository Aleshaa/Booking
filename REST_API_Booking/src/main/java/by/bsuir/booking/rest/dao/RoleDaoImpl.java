package by.bsuir.booking.rest.dao;

import by.bsuir.booking.rest.model.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RoleDaoImpl implements RoleDao{

    @Autowired
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;

    private static final RoleDaoImpl instance = new RoleDaoImpl();

    public RoleDaoImpl(){}

    public static RoleDaoImpl getInstance(){
        return instance;
    }

    @Override
    public boolean add(Role role) throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        session.save(role);
        tx.commit();
        session.close();

        return false;
    }

    @Override
    public boolean addS(List<Role> roles) throws Exception {
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
    public boolean update(Role role) throws Exception {
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
    public boolean updateS(List<Role> roles) throws Exception {
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
    public Role getById(int id) throws Exception {
        session = sessionFactory.openSession();
        Role role = (Role) session.load(Role.class, new Integer(id));
        tx = session.getTransaction();
        session.beginTransaction();
        tx.commit();
        return role;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Role> getList() throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        List<Role> roleList = session.createCriteria(Role.class).list();
        tx.commit();
        session.close();
        return roleList;
    }

    @Override
    public boolean delete(int id) throws Exception {
        session = sessionFactory.openSession();
        Object o = session.load(Role.class, id);
        tx = session.getTransaction();
        session.beginTransaction();
        session.delete(o);
        tx.commit();
        return false;
    }

    @Override
    public boolean deleteAll() throws Exception {
        session = sessionFactory.openSession();
        tx = session.getTransaction();
        session.beginTransaction();
        session.createQuery("DELETE FROM Role").executeUpdate();
        tx.commit();
        return false;
    }


}
