package by.bsuir.booking.rest.services;

import by.bsuir.booking.rest.dao.TypeRoomDao;
import by.bsuir.booking.rest.model.Typeroom;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TypeRoomServicesImpl implements TypeRoomServices{
    @Autowired
    TypeRoomDao typeRoomDao;

    @Override
    public boolean addTypeRoom(Typeroom typeRoom) throws Exception {
        return typeRoomDao.add(typeRoom);
    }

    @Override
    public boolean addTypesRoom(List<Typeroom> typesRoom) throws Exception {
        return typeRoomDao.addS(typesRoom);
    }

    @Override
    public boolean updateTypeRoom(Typeroom typeRoom) throws Exception {
        return typeRoomDao.update(typeRoom);
    }

    @Override
    public boolean updateTypesRoom(List<Typeroom> typesRoom) throws Exception {
        return typeRoomDao.updateS(typesRoom);
    }

    @Override
    public Typeroom getTypeRoomById(int id) throws Exception {
        return typeRoomDao.getById(id);
    }

    @Override
    public List<Typeroom> getTypeRoomList() throws Exception {
        return typeRoomDao.getList();
    }

    @Override
    public Typeroom getTypeRoomByName(String name) throws Exception {
        return typeRoomDao.getTypeRoomByName(name);
    }

    @Override
    public boolean deleteTypeRoom(int id) throws Exception {
        return typeRoomDao.delete(id);
    }

    @Override
    public boolean deleteAllTypesRoom() throws Exception {
        return typeRoomDao.deleteAll();
    }
}
