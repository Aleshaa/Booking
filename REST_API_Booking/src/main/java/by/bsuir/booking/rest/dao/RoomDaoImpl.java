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
        return false;
    }

    @Override
    public boolean addRooms(List<Room> rooms) throws Exception {
        return false;
    }

    @Override
    public boolean updateRoom(Room room) throws Exception {
        return false;
    }

    @Override
    public boolean updateRooms(List<Room> rooms) throws Exception {
        return false;
    }

    @Override
    public Room getRoomById(int id) throws Exception {
        return null;
    }

    @Override
    public List<Room> getRoomList() throws Exception {
        return null;
    }

    @Override
    public boolean deleteRoom(int id) throws Exception {
        return false;
    }

    @Override
    public boolean deleteAllRooms() throws Exception {
        return false;
    }
}
