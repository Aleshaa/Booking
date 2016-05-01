package by.bsuir.booking.client.service;

import by.bsuir.booking.client.model.Check_r;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public interface Check_rService {

    void save(Check_r check_r) throws IOException;

    void update(Check_r check_r) throws IOException, ParseException;

    Check_r getByID(int id) throws IOException, ParseException;

    List<Check_r> getAll() throws IOException, ParseException;

    void delete(int id) throws IOException;

}
