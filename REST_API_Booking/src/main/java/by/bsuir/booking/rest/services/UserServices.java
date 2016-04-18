package by.bsuir.booking.rest.services;

import by.bsuir.booking.rest.model.User;

import java.util.List;

/**
 * Created by User on 11.04.2016.
 */
public interface UserServices {
    public boolean addUser(User user) throws Exception;
    public boolean addUsers(List<User> users) throws Exception;
    public boolean updateUser(User user) throws Exception;
    public boolean updateUsers(List<User> users) throws Exception;
    public User getUserById(int id) throws Exception;
    public List<User> getUserList() throws Exception;
    public boolean deleteUser(int id) throws Exception;
    public boolean deleteAllUsers() throws Exception;
}
