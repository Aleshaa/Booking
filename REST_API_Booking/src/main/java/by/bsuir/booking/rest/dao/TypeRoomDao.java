package by.bsuir.booking.rest.dao;

import by.bsuir.booking.rest.model.Typeroom;

import java.util.List;

/**
 * Created by User on 11.04.2016.
 */
public interface TypeRoomDao {
    public boolean addTypeRoom(Typeroom typeRoom) throws Exception;
    public boolean addTypesRoom(List<Typeroom> typesRoom) throws Exception;
    public boolean updateTypeRoom(Typeroom typeRoom) throws Exception;
    public boolean updateTypesRoom(List<Typeroom> typesRoom) throws Exception;
    public Typeroom getTypeRoomById(int id) throws Exception;
    public Typeroom getTypeRoomByName(String name) throws Exception;
    public List<Typeroom> getTypeRoomList() throws Exception;
    public boolean deleteTypeRoom(int id) throws Exception;
    public boolean deleteAllTypesRoom() throws Exception;
}
