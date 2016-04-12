package by.bsuir.booking.rest.dao;

import by.bsuir.booking.rest.model.Typeroom;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by User on 11.04.2016.
 */
public class TypeRoomDaoImpl implements TypeRoomDao{
    @Autowired
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;

    @Override
    public boolean addTypeRoom(Typeroom typeRoom) throws Exception {
        return false;
    }

    @Override
    public boolean addTypesRoom(List<Typeroom> typesRoom) throws Exception {
        return false;
    }

    @Override
    public boolean updateTypeRoom(Typeroom typeRoom) throws Exception {
        return false;
    }

    @Override
    public boolean updateTypesRoom(List<Typeroom> typesRoom) throws Exception {
        return false;
    }

    @Override
    public Typeroom getTypeRoomById(int id) throws Exception {
        return null;
    }

    @Override
    public List<Typeroom> getTypeRoomList() throws Exception {
        return null;
    }

    @Override
    public boolean deleteTypeRoom(int id) throws Exception {
        return false;
    }

    @Override
    public boolean deleteAllTypesRoom() throws Exception {
        return false;
    }
}
