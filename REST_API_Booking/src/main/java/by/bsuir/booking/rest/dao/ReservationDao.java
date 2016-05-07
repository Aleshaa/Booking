package by.bsuir.booking.rest.dao;

import by.bsuir.booking.rest.model.Reservation;

import java.util.List;

public interface ReservationDao extends IDAO<Reservation> {
    public boolean add(Reservation reservation) throws Exception;
    public boolean addS(List<Reservation> reservations) throws Exception;
    public boolean update(Reservation reservation) throws Exception;
    public boolean updateS(List<Reservation> reservations) throws Exception;
    public Reservation getById(int id) throws Exception;
    public List<Reservation> getList() throws Exception;
    public boolean delete(int id) throws Exception;
    public boolean deleteAll() throws Exception;
}
