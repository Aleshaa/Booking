package by.bsuir.booking.client.service;

import by.bsuir.booking.client.model.Role;

import java.io.IOException;
import java.text.ParseException;

/**
 * Created by User on 24.04.2016.
 */
public interface RoleService {

    Role getRoleByID(int id) throws IOException, ParseException;
}
