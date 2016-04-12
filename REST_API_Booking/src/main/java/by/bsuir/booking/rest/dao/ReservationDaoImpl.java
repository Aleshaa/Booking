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
        return false;
    }

    @Override
    public boolean addReservations(List<Reservation> reservations) throws Exception {
        return false;
    }

    @Override
    public boolean updateReservation(Reservation reservation) throws Exception {
        return false;
    }

    @Override
    public boolean updateReservations(List<Reservation> reservations) throws Exception {
        return false;
    }

    @Override
    public Reservation getReservationById(int id) throws Exception {
        return null;
    }

    @Override
    public List<Reservation> getReservationList() throws Exception {
        return null;
    }

    @Override
    public boolean deleteReservation(int id) throws Exception {
        return false;
    }

    @Override
    public boolean deleteAllReservations() throws Exception {
        return false;
    }

}
