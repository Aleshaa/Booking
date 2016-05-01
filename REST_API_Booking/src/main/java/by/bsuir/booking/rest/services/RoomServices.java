package by.bsuir.booking.rest.services;

import by.bsuir.booking.rest.model.Room;

import java.util.List;


public interface RoomServices {
    public boolean addRoom(Room room) throws Exception;
    public boolean addRooms(List<Room> rooms) throws Exception;
    public boolean updateRoom(Room room) throws Exception;
    public boolean updateRooms(List<Room> rooms) throws Exception;
    public Room getRoomById(int id) throws Exception;
    public Room getRoomByN(int id) throws Exception;
    public List<Room> getRoomList() throws Exception;
    public boolean deleteRoom(int id) throws Exception;
    public boolean deleteAllRooms() throws Exception;
}
