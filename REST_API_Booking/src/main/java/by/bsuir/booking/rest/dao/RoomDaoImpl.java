package by.bsuir.booking.rest.dao;

import by.bsuir.booking.rest.model.Room;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by User on 11.04.2016.
 */
public class RoomDaoImpl implements RoomDao{

    @Autowired
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;

    @Override
    public boolean addRoom(Room room) throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        session.save(room);
        tx.commit();
        session.close();

        return false;
    }

    @Override
    public boolean addRooms(List<Room> rooms) throws Exception {
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
    public boolean updateRoom(Room room) throws Exception {
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
    public boolean updateRooms(List<Room> rooms) throws Exception {
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
    public Room getRoomById(int id) throws Exception {
        session = sessionFactory.openSession();
        Room room = (Room) session.load(Room.class, new Integer(id));
        tx = session.getTransaction();
        session.beginTransaction();
        tx.commit();
        return room;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Room> getRoomList() throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        List<Room> roomList = session.createCriteria(Room.class).list();
        tx.commit();
        session.close();
        return roomList;
    }

    @Override
    public boolean deleteRoom(int id) throws Exception {
        session = sessionFactory.openSession();
        Object o = session.load(Room.class, id);
        tx = session.getTransaction();
        session.beginTransaction();
        session.delete(o);
        tx.commit();
        return false;
    }

    @Override
    public boolean deleteAllRooms() throws Exception {
        session = sessionFactory.openSession();
        tx = session.getTransaction();
        session.beginTransaction();
        session.createQuery("DELETE FROM Room").executeUpdate();
        tx.commit();
        return false;
    }
}
