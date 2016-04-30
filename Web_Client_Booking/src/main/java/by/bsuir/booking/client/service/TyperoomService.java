package by.bsuir.booking.client.service;

import by.bsuir.booking.client.model.Typeroom;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

/**
 * Created by User on 25.04.2016.
 */
public interface TyperoomService {

    void save(Typeroom typeroom) throws IOException, ParseException;

    void update(Typeroom typeroom) throws IOException, ParseException;

    Typeroom getTypeRoomByID(int id) throws IOException, ParseException;

    Typeroom getTypeRoomByName(String name) throws IOException, ParseException;

    List<Typeroom> getAllTypeRoom() throws IOException, ParseException;

    void delTTypeRoom(int id) throws IOException;
}
