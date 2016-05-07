package by.bsuir.booking.rest.dao;

import by.bsuir.booking.rest.model.Reservation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class ReservationDaoImpl implements ReservationDao{

    @Autowired
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;

    private static final ReservationDaoImpl instance = new ReservationDaoImpl();

    public ReservationDaoImpl(){}

    public static ReservationDaoImpl getInstance(){
        return instance;
    }

    @Override
    public boolean add(Reservation reservation) throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        session.save(reservation);
        tx.commit();
        session.close();

        return false;
    }

    @Override
    public boolean addS(List<Reservation> reservations) throws Exception {
        session = sessionFactory.openSession();

        for(Reservation reservation:reservations) {
            tx = session.beginTransaction();
            session.save(reservation);
            tx.commit();
        }
        session.close();

        return false;
    }

    @Override
    public boolean update(Reservation reservation) throws Exception {
        session = sessionFactory.openSession();
        Reservation reservation1;
        reservation1 = (Reservation) session.load(Reservation.class, reservation.getIdReserv());
        tx = session.getTransaction();
        reservation1 = reservation;
        tx = session.beginTransaction();
        session.saveOrUpdate(reservation1);
        tx.commit();
        session.close();
        return false;
    }

    @Override
    public boolean updateS(List<Reservation> reservations) throws Exception {
        session = sessionFactory.openSession();
        for(Reservation reservation:reservations) {
            Reservation reservation1;
            reservation1 = (Reservation) session.load(Reservation.class, reservation.getIdReserv());
            tx = session.getTransaction();
            reservation1 = reservation;
            tx = session.beginTransaction();
            session.saveOrUpdate(reservation1);
            tx.commit();
        }
        session.close();
        return false;
    }

    @Override
    public Reservation getById(int id) throws Exception {
        session = sessionFactory.openSession();
        Reservation reservation = (Reservation) session.load(Reservation.class, new Integer(id));
        tx = session.getTransaction();
        session.beginTransaction();
        tx.commit();
        return reservation;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Reservation> getList() throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        List<Reservation> reservationList = session.createCriteria(Reservation.class).list();
        tx.commit();
        session.close();
        return reservationList;
    }

    @Override
    public boolean delete(int id) throws Exception {
        session = sessionFactory.openSession();
        Object o = session.load(Reservation.class, id);
        tx = session.getTransaction();
        session.beginTransaction();
        session.delete(o);
        tx.commit();
        return false;
    }

    @Override
    public boolean deleteAll() throws Exception {
        session = sessionFactory.openSession();
        tx = session.getTransaction();
        session.beginTransaction();
        session.createQuery("DELETE FROM Reservation").executeUpdate();
        tx.commit();
        return false;
    }

}
