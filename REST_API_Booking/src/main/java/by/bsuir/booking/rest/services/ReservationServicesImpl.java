package by.bsuir.booking.rest.services;

import by.bsuir.booking.rest.dao.ReservationDao;
import by.bsuir.booking.rest.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ReservationServicesImpl implements ReservationServices {
    @Autowired
    ReservationDao reservationDao;

    @Override
    public boolean addReservation(Reservation reservation) throws Exception {
        return reservationDao.add(reservation);
    }

    @Override
    public boolean addReservations(List<Reservation> reservations) throws Exception {
        return reservationDao.addS(reservations);
    }

    @Override
    public boolean updateReservation(Reservation reservation) throws Exception {
        return reservationDao.update(reservation);
    }

    @Override
    public boolean updateReservations(List<Reservation> reservations) throws Exception {
        return reservationDao.updateS(reservations);
    }

    @Override
    public Reservation getReservationById(int id) throws Exception {
        return reservationDao.getById(id);
    }

    @Override
    public List<Reservation> getReservationList() throws Exception {
        return reservationDao.getList();
    }

    @Override
    public boolean deleteReservation(int id) throws Exception {
        return reservationDao.delete(id);
    }

    @Override
    public boolean deleteAllReservations() throws Exception {
        return reservationDao.deleteAll();
    }
}
