package by.bsuir.booking.client.service;


import by.bsuir.booking.client.model.Reservation;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public interface ReservationService {

    void save(Reservation reservation) throws IOException;

    void update(Reservation reservation) throws IOException, ParseException;

    Reservation getReservationByID(int id) throws IOException, ParseException;

    List<Reservation> getAll() throws IOException, ParseException;

    void delete(int id) throws IOException;
}
