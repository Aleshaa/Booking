package by.bsuir.booking.rest.dao;

import by.bsuir.booking.rest.model.User;

import java.util.List;

public interface UserDao extends IDAO<User>{
    public boolean add(User user) throws Exception;
    public boolean addS(List<User> users) throws Exception;
    public boolean update(User user) throws Exception;
    public boolean updateS(List<User> users) throws Exception;
    public User getById(int id) throws Exception;
    public User getUserByName(String name) throws Exception;
    public List<User> getList() throws Exception;
    public boolean delete(int id) throws Exception;
    public boolean deleteAll() throws Exception;
}
