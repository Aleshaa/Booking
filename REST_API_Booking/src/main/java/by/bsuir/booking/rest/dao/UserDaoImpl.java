package by.bsuir.booking.rest.dao;

import by.bsuir.booking.rest.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by User on 11.04.2016.
 */
public class UserDaoImpl implements UserDao {
    @Autowired
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;

    @Override
    public boolean addUser(User user) throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        session.save(user);
        tx.commit();
        session.close();

        return false;
    }

    @Override
    public boolean addUsers(List<User> users) throws Exception {
        session = sessionFactory.openSession();

        for(User user:users) {
            tx = session.beginTransaction();
            session.save(user);
            tx.commit();
        }
        session.close();

        return false;
    }

    @Override
    public boolean updateUser(User user) throws Exception {
        session = sessionFactory.openSession();
        User user1;
        user1 = (User) session.load(User.class, user.getIdUser());
        tx = session.getTransaction();
        user1 = user;
        tx = session.beginTransaction();
        session.saveOrUpdate(user1);
        tx.commit();
        session.close();
        return false;
    }

    @Override
    public boolean updateUsers(List<User> users) throws Exception {
        session = sessionFactory.openSession();
        for(User user:users) {
            User user1;
            user1 = (User) session.load(User.class, user.getIdUser());
            tx = session.getTransaction();
            user1 = user;
            tx = session.beginTransaction();
            session.saveOrUpdate(user1);
            tx.commit();
        }
        session.close();
        return false;
    }

    @Override
    public User getUserById(int id) throws Exception {
        session = sessionFactory.openSession();
        User user = (User) session.load(User.class, new Integer(id));
        tx = session.getTransaction();
        session.beginTransaction();
        tx.commit();
        return user;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> getUserList() throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        List<User> userList = session.createCriteria(User.class).list();
        tx.commit();
        session.close();
        return userList;
    }

    @Override
    public boolean deleteUser(int id) throws Exception {
        session = sessionFactory.openSession();
        Object o = session.load(User.class, id);
        tx = session.getTransaction();
        session.beginTransaction();
        session.delete(o);
        tx.commit();
        return false;
    }

    @Override
    public boolean deleteAllUsers() throws Exception {
        session = sessionFactory.openSession();
        tx = session.getTransaction();
        session.beginTransaction();
        session.createQuery("DELETE FROM User").executeUpdate();
        tx.commit();
        return false;
    }

}
