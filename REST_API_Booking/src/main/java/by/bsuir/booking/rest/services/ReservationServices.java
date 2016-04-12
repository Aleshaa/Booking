package by.bsuir.booking.rest.services;

import by.bsuir.booking.rest.model.Reservation;

import java.util.List;

/**
 * Created by User on 11.04.2016.
 */
public interface ReservationServices {
    public boolean addReservation(Reservation reservation) throws Exception;
    public boolean addReservations(List<Reservation> reservations) throws Exception;
    public boolean updateReservation(Reservation reservation) throws Exception;
    public boolean updateReservations(List<Reservation> reservations) throws Exception;
    public Reservation getReservationById(int id) throws Exception;
    public List<Reservation> getReservationList() throws Exception;
    public boolean deleteReservation(int id) throws Exception;
    public boolean deleteAllReservations() throws Exception;
}
