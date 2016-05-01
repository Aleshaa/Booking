package by.bsuir.booking.rest.services;

import by.bsuir.booking.rest.dao.RoomDao;
import by.bsuir.booking.rest.model.Room;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RoomServicesImpl implements RoomServices {
    @Autowired
    RoomDao roomDao;

    @Override
    public boolean addRoom(Room room) throws Exception {
        return roomDao.addRoom(room);
    }

    @Override
    public boolean addRooms(List<Room> rooms) throws Exception {
        return roomDao.addRooms(rooms);
    }

    @Override
    public boolean updateRoom(Room room) throws Exception {
        return roomDao.updateRoom(room);
    }

    @Override
    public boolean updateRooms(List<Room> rooms) throws Exception {
        return roomDao.updateRooms(rooms);
    }

    @Override
    public Room getRoomById(int id) throws Exception {
        return roomDao.getRoomById(id);
    }

    @Override
    public Room getRoomByN(int N) throws Exception {
        return roomDao.getRoomByN(N);
    }

    @Override
    public List<Room> getRoomList() throws Exception {
        return roomDao.getRoomList();
    }

    @Override
    public boolean deleteRoom(int id) throws Exception {
        return roomDao.deleteRoom(id);
    }

    @Override
    public boolean deleteAllRooms() throws Exception {
        return roomDao.deleteAllRooms();
    }
}
