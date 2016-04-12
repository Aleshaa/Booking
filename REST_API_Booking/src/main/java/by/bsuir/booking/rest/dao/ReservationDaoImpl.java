package by.bsuir.booking.rest.dao;

import by.bsuir.booking.rest.model.Reservation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by User on 11.04.2016.
 */
public class ReservationDaoImpl implements ReservationDao{

    @Autowired
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;

    @Override
    public boolean addReservation(Reservation reservation) throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        session.save(reservation);
        tx.commit();
        session.close();

        return false;
    }

    @Override
    public boolean addReservations(List<Reservation> reservations) throws Exception {
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
    public boolean updateReservation(Reservation reservation) throws Exception {
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
    public boolean updateReservations(List<Reservation> reservations) throws Exception {
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
    public Reservation getReservationById(int id) throws Exception {
        session = sessionFactory.openSession();
        Reservation reservation = (Reservation) session.load(Reservation.class, new Integer(id));
        tx = session.getTransaction();
        session.beginTransaction();
        tx.commit();
        return reservation;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Reservation> getReservationList() throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        List<Reservation> reservationList = session.createCriteria(Reservation.class).list();
        tx.commit();
        session.close();
        return reservationList;
    }

    @Override
    public boolean deleteReservation(int id) throws Exception {
        session = sessionFactory.openSession();
        Object o = session.load(Reservation.class, id);
        tx = session.getTransaction();
        session.beginTransaction();
        session.delete(o);
        tx.commit();
        return false;
    }

    @Override
    public boolean deleteAllReservations() throws Exception {
        session = sessionFactory.openSession();
        tx = session.getTransaction();
        session.beginTransaction();
        session.createQuery("DELETE FROM Reservation").executeUpdate();
        tx.commit();
        return false;
    }

}
