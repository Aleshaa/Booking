package by.bsuir.booking.rest.dao;

import by.bsuir.booking.rest.model.Room;

import java.util.List;

/**
 * Created by User on 11.04.2016.
 */
public interface RoomDao {
    public boolean addRoom(Room room) throws Exception;
    public boolean addRooms(List<Room> rooms) throws Exception;
    public boolean updateRoom(Room room) throws Exception;
    public boolean updateRooms(List<Room> rooms) throws Exception;
    public Room getRoomById(int id) throws Exception;
    public Room getRoomByN(int N) throws Exception;
    public List<Room> getRoomList() throws Exception;
    public boolean deleteRoom(int id) throws Exception;
    public boolean deleteAllRooms() throws Exception;
}
