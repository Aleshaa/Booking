package by.bsuir.booking.client.service;


import by.bsuir.booking.client.model.Room;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public interface RoomService {

    void save(Room room) throws IOException;

    void update(Room room) throws IOException, ParseException;

    Room getRoomByID(int id) throws IOException, ParseException;

    Room getByRoomN(int id) throws IOException, ParseException;

    List<Room> getAllRooms() throws IOException, ParseException;

    void delRoom(int id) throws IOException;

}
