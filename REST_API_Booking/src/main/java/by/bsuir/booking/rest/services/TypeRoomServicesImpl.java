package by.bsuir.booking.rest.services;

import by.bsuir.booking.rest.dao.TypeRoomDao;
import by.bsuir.booking.rest.model.Typeroom;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by User on 11.04.2016.
 */
public class TypeRoomServicesImpl implements TypeRoomServices{
    @Autowired
    TypeRoomDao typeRoomDao;

    @Override
    public boolean addTypeRoom(Typeroom typeRoom) throws Exception {
        return typeRoomDao.addTypeRoom(typeRoom);
    }

    @Override
    public boolean addTypesRoom(List<Typeroom> typesRoom) throws Exception {
        return typeRoomDao.addTypesRoom(typesRoom);
    }

    @Override
    public boolean updateTypeRoom(Typeroom typeRoom) throws Exception {
        return typeRoomDao.updateTypeRoom(typeRoom);
    }

    @Override
    public boolean updateTypesRoom(List<Typeroom> typesRoom) throws Exception {
        return typeRoomDao.updateTypesRoom(typesRoom);
    }

    @Override
    public Typeroom getTypeRoomById(int id) throws Exception {
        return typeRoomDao.getTypeRoomById(id);
    }

    @Override
    public List<Typeroom> getTypeRoomList() throws Exception {
        return typeRoomDao.getTypeRoomList();
    }

    @Override
    public Typeroom getTypeRoomByName(String name) throws Exception {
        return typeRoomDao.getTypeRoomByName(name);
    }

    @Override
    public boolean deleteTypeRoom(int id) throws Exception {
        return typeRoomDao.deleteTypeRoom(id);
    }

    @Override
    public boolean deleteAllTypesRoom() throws Exception {
        return typeRoomDao.deleteAllTypesRoom();
    }
}
