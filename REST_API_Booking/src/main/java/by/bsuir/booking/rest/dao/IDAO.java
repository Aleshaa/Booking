package by.bsuir.booking.rest.dao;

import java.util.List;

public interface IDAO<T> {

    public boolean add(T element) throws Exception;
    public boolean addS(List<T> elements) throws Exception;
    public boolean update(T element) throws Exception;
    public boolean updateS(List<T> elements) throws Exception;
    public T getById(int id) throws Exception;
    public List<T> getList() throws Exception;
    public boolean delete(int id) throws Exception;
    public boolean deleteAll() throws Exception;

}
