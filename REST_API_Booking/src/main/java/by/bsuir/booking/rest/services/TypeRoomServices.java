package by.bsuir.booking.rest.services;

import by.bsuir.booking.rest.model.Typeroom;

import java.util.List;

/**
 * Created by User on 11.04.2016.
 */
public interface TypeRoomServices {
    public boolean addTypeRoom(Typeroom typeRoom) throws Exception;
    public boolean addTypesRoom(List<Typeroom> typesRoom) throws Exception;
    public boolean updateTypeRoom(Typeroom typeRoom) throws Exception;
    public boolean updateTypesRoom(List<Typeroom> typesRoom) throws Exception;
    public Typeroom getTypeRoomById(int id) throws Exception;
    public List<Typeroom> getTypeRoomList() throws Exception;
    public Typeroom getTypeRoomByName(String name) throws Exception;
    public boolean deleteTypeRoom(int id) throws Exception;
    public boolean deleteAllTypesRoom() throws Exception;
}
