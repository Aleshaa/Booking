package by.bsuir.booking.rest.dao;

import by.bsuir.booking.rest.model.Room;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class RoomDaoImpl implements RoomDao{

    @Autowired
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;

    private static final RoomDaoImpl instance = new RoomDaoImpl();

    public RoomDaoImpl(){}

    public static RoomDaoImpl getInstance(){
        return instance;
    }

    @Override
    public boolean add(Room room) throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        session.save(room);
        tx.commit();
        session.close();

        return false;
    }

    @Override
    public boolean addS(List<Room> rooms) throws Exception {
        session = sessionFactory.openSession();

        for(Room room:rooms) {
            tx = session.beginTransaction();
            session.save(room);
            tx.commit();
        }
        session.close();

        return false;
    }

    @Override
    public boolean update(Room room) throws Exception {
        session = sessionFactory.openSession();
        Room room1;
        room1 = (Room) session.load(Room.class, room.getIdRoom());
        tx = session.getTransaction();
        room1 = room;
        tx = session.beginTransaction();
        session.saveOrUpdate(room1);
        tx.commit();
        session.close();
        return false;
    }

    @Override
    public boolean updateS(List<Room> rooms) throws Exception {
        session = sessionFactory.openSession();
        for(Room room:rooms) {
            Room room1;
            room1 = (Room) session.load(Room.class, room.getIdRoom());
            tx = session.getTransaction();
            room1 = room;
            tx = session.beginTransaction();
            session.saveOrUpdate(room1);
            tx.commit();
        }
        session.close();
        return false;
    }

    @Override
    public Room getById(int id) throws Exception {
        session = sessionFactory.openSession();
        Room room = (Room) session.load(Room.class, new Integer(id));
        tx = session.getTransaction();
        session.beginTransaction();
        tx.commit();
        return room;
    }

    @Override
    public Room getRoomByN(int N) throws Exception {
        session = sessionFactory.openSession();
        tx = session.getTransaction();
        session.beginTransaction();
        String hql = "FROM Room R WHERE R.nRoom = :N";
        Query query = session.createQuery(hql);
        query.setParameter("N", N);
        Room user = (Room) query.uniqueResult();
        tx.commit();
        return user;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Room> getList() throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        List<Room> roomList = session.createCriteria(Room.class).list();
        tx.commit();
        session.close();
        return roomList;
    }

    @Override
    public boolean delete(int id) throws Exception {
        session = sessionFactory.openSession();
        Object o = session.load(Room.class, id);
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
        session.createQuery("DELETE FROM Room").executeUpdate();
        tx.commit();
        return false;
    }
}
