package by.bsuir.booking.client.service;

import by.bsuir.booking.client.model.User;

import java.io.IOException;
import java.text.ParseException;

import java.util.List;

public interface UserService {
    void save(User user) throws IOException;

    User findByUsername(String username) throws IOException, ParseException;

    List<User> getAllUsers() throws IOException, ParseException;

    void delUser(int id) throws IOException;
}
