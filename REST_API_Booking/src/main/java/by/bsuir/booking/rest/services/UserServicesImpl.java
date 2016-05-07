package by.bsuir.booking.rest.services;

import by.bsuir.booking.rest.dao.UserDao;
import by.bsuir.booking.rest.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class UserServicesImpl implements UserServices{
    @Autowired
    UserDao userDao;

    @Override
    public boolean addUser(User user) throws Exception {
        return userDao.add(user);
    }

    @Override
    public boolean addUsers(List<User> users) throws Exception {
        return userDao.addS(users);
    }

    @Override
    public boolean updateUser(User user) throws Exception {
        return userDao.update(user);
    }

    @Override
    public boolean updateUsers(List<User> users) throws Exception {
        return userDao.updateS(users);
    }

    @Override
    public User getUserById(int id) throws Exception {
        return userDao.getById(id);
    }

    @Override
    public User getUserByName(String name) throws Exception {
        return userDao.getUserByName(name);
    }

    @Override
    public List<User> getUserList() throws Exception {
        return userDao.getList();
    }

    @Override
    public boolean deleteUser(int id) throws Exception {
        return userDao.delete(id);
    }

    @Override
    public boolean deleteAllUsers() throws Exception {
        return userDao.deleteAll();
    }
}
