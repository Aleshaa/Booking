package by.bsuir.booking.rest.dao;

import by.bsuir.booking.rest.model.Typeroom;

import java.util.List;


public interface TypeRoomDao extends IDAO<Typeroom> {
    public boolean add(Typeroom typeRoom) throws Exception;
    public boolean addS(List<Typeroom> typesRoom) throws Exception;
    public boolean update(Typeroom typeRoom) throws Exception;
    public boolean updateS(List<Typeroom> typesRoom) throws Exception;
    public Typeroom getById(int id) throws Exception;
    public Typeroom getTypeRoomByName(String name) throws Exception;
    public List<Typeroom> getList() throws Exception;
    public boolean delete(int id) throws Exception;
    public boolean deleteAll() throws Exception;
}
