package by.bsuir.booking.rest.services;

import by.bsuir.booking.rest.dao.ReservationDao;
import by.bsuir.booking.rest.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by User on 11.04.2016.
 */
public class ReservationServicesImpl implements ReservationServices {
    @Autowired
    ReservationDao reservationDao;

    @Override
    public boolean addReservation(Reservation reservation) throws Exception {
        return reservationDao.addReservation(reservation);
    }

    @Override
    public boolean addReservations(List<Reservation> reservations) throws Exception {
        return reservationDao.addReservations(reservations);
    }

    @Override
    public boolean updateReservation(Reservation reservation) throws Exception {
        return reservationDao.updateReservation(reservation);
    }

    @Override
    public boolean updateReservations(List<Reservation> reservations) throws Exception {
        return reservationDao.updateReservations(reservations);
    }

    @Override
    public Reservation getReservationById(int id) throws Exception {
        return reservationDao.getReservationById(id);
    }

    @Override
    public List<Reservation> getReservationList() throws Exception {
        return reservationDao.getReservationList();
    }

    @Override
    public boolean deleteReservation(int id) throws Exception {
        return reservationDao.deleteReservation(id);
    }

    @Override
    public boolean deleteAllReservations() throws Exception {
        return reservationDao.deleteAllReservations();
    }
}
