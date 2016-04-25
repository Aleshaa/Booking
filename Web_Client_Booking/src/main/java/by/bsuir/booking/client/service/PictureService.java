package by.bsuir.booking.client.service;

import by.bsuir.booking.client.model.Picture;

import java.io.IOException;
import java.text.ParseException;

/**
 * Created by User on 25.04.2016.
 */
public interface PictureService {

    Picture getPictureByID(int id) throws IOException, ParseException;

    void save(Picture picture) throws IOException;

}
