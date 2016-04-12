package by.bsuir.booking.rest.services;

import by.bsuir.booking.rest.dao.UserDao;
import by.bsuir.booking.rest.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by User on 11.04.2016.
 */
public class UserServicesImpl implements UserServices{
    @Autowired
    UserDao userDao;

    @Override
    public boolean addUser(User user) throws Exception {
        return userDao.addUser(user);
    }

    @Override
    public boolean addUsers(List<User> users) throws Exception {
        return userDao.addUsers(users);
    }

    @Override
    public boolean updateUser(User user) throws Exception {
        return userDao.updateUser(user);
    }

    @Override
    public boolean updateUsers(List<User> users) throws Exception {
        return userDao.updateUsers(users);
    }

    @Override
    public User getUserById(int id) throws Exception {
        return userDao.getUserById(id);
    }

    @Override
    public List<User> getUserList() throws Exception {
        return userDao.getUserList();
    }

    @Override
    public boolean deleteUser(int id) throws Exception {
        return userDao.deleteUser(id);
    }

    @Override
    public boolean deleteAllUsers() throws Exception {
        return userDao.deleteAllUsers();
    }
}
