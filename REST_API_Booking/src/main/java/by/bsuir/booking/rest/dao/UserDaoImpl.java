package by.bsuir.booking.rest.dao;

import by.bsuir.booking.rest.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserDaoImpl implements UserDao {
    @Autowired
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;

    private static final UserDaoImpl instance = new UserDaoImpl();

    public UserDaoImpl(){}

    public static UserDaoImpl getInstance(){
        return instance;
    }

    @Override
    public boolean add(User user) throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        session.save(user);
        tx.commit();
        session.close();

        return false;
    }

    @Override
    public boolean addS(List<User> users) throws Exception {
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
    public boolean update(User user) throws Exception {
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
    public boolean updateS(List<User> users) throws Exception {
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
    public User getById(int id) throws Exception {
        session = sessionFactory.openSession();
        User user = (User) session.load(User.class, new Integer(id));
        tx = session.getTransaction();
        session.beginTransaction();
        tx.commit();
        return user;
    }

    @Override
    public User getUserByName(String name) throws Exception {
        session = sessionFactory.openSession();
        tx = session.getTransaction();
        session.beginTransaction();
        String hql = "FROM User U WHERE U.username = :name";
        Query query = session.createQuery(hql);
        query.setParameter("name", name);
        User user = (User) query.uniqueResult();
        tx.commit();
        return user;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> getList() throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        List<User> userList = session.createCriteria(User.class).list();
        tx.commit();
        session.close();
        return userList;
    }

    @Override
    public boolean delete(int id) throws Exception {
        session = sessionFactory.openSession();
        Object o = session.load(User.class, id);
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
        session.createQuery("DELETE FROM User").executeUpdate();
        tx.commit();
        return false;
    }

}
