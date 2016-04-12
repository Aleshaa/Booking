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
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        session.save(typeRoom);
        tx.commit();
        session.close();

        return false;
    }

    @Override
    public boolean addTypesRoom(List<Typeroom> typesRoom) throws Exception {
        session = sessionFactory.openSession();

        for(Typeroom typeroom:typesRoom) {
            tx = session.beginTransaction();
            session.save(typeroom);
            tx.commit();
        }
        session.close();

        return false;
    }

    @Override
    public boolean updateTypeRoom(Typeroom typeRoom) throws Exception {
        session = sessionFactory.openSession();
        Typeroom typeRoom1;
        typeRoom1 = (Typeroom) session.load(Typeroom.class, typeRoom.getIdTRoom());
        tx = session.getTransaction();
        typeRoom1 = typeRoom;
        tx = session.beginTransaction();
        session.saveOrUpdate(typeRoom1);
        tx.commit();
        session.close();
        return false;
    }

    @Override
    public boolean updateTypesRoom(List<Typeroom> typesRoom) throws Exception {
        session = sessionFactory.openSession();
        for(Typeroom typeRoom:typesRoom) {
            Typeroom typeRoom1;
            typeRoom1 = (Typeroom) session.load(Typeroom.class, typeRoom.getIdTRoom());
            tx = session.getTransaction();
            typeRoom1 = typeRoom;
            tx = session.beginTransaction();
            session.saveOrUpdate(typeRoom1);
            tx.commit();
        }
        session.close();
        return false;
    }

    @Override
    public Typeroom getTypeRoomById(int id) throws Exception {
        session = sessionFactory.openSession();
        Typeroom typeRoom = (Typeroom) session.load(Typeroom.class, new Integer(id));
        tx = session.getTransaction();
        session.beginTransaction();
        tx.commit();
        return typeRoom;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Typeroom> getTypeRoomList() throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        List<Typeroom> typeRoomList = session.createCriteria(Typeroom.class).list();
        tx.commit();
        session.close();
        return typeRoomList;
    }

    @Override
    public boolean deleteTypeRoom(int id) throws Exception {
        session = sessionFactory.openSession();
        Object o = session.load(Typeroom.class, id);
        tx = session.getTransaction();
        session.beginTransaction();
        session.delete(o);
        tx.commit();
        return false;
    }

    @Override
    public boolean deleteAllTypesRoom() throws Exception {
        session = sessionFactory.openSession();
        tx = session.getTransaction();
        session.beginTransaction();
        session.createQuery("DELETE FROM Typeroom").executeUpdate();
        tx.commit();
        return false;
    }
}
