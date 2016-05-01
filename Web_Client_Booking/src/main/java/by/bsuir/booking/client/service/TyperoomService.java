package by.bsuir.booking.client.service;

import by.bsuir.booking.client.model.Typeroom;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public interface TyperoomService {

    void save(Typeroom typeroom) throws IOException, ParseException;

    void update(Typeroom typeroom) throws IOException, ParseException;

    Typeroom getTypeRoomByID(int id) throws IOException, ParseException;

    Typeroom getTypeRoomByName(String name) throws IOException, ParseException;

    List<Typeroom> getAllTypeRoom() throws IOException, ParseException;

    void delTTypeRoom(int id) throws IOException;
}
