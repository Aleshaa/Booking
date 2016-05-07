package by.bsuir.booking.rest.dao;

import by.bsuir.booking.rest.model.Room;

import java.util.List;


public interface RoomDao extends IDAO<Room>{
    public boolean add(Room room) throws Exception;
    public boolean addS(List<Room> rooms) throws Exception;
    public boolean update(Room room) throws Exception;
    public boolean updateS(List<Room> rooms) throws Exception;
    public Room getById(int id) throws Exception;
    public Room getRoomByN(int N) throws Exception;
    public List<Room> getList() throws Exception;
    public boolean delete(int id) throws Exception;
    public boolean deleteAll() throws Exception;
}
