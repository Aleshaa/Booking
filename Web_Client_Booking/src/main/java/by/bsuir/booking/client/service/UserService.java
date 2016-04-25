package by.bsuir.booking.client.service;

import by.bsuir.booking.client.model.User;

import java.io.IOException;
import java.text.ParseException;

public interface UserService {
    void save(User user) throws IOException;

    User findByUsername(String username) throws IOException, ParseException;
}
