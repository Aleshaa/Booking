package by.bsuir.booking.rest.dao;

import by.bsuir.booking.rest.model.Picture;

import java.util.List;


public interface PictureDao extends IDAO<Picture> {
    public boolean add(Picture pic) throws Exception;
    public boolean addS(List<Picture> pictures) throws Exception;
    public boolean update(Picture picture) throws Exception;
    public boolean updateS(List<Picture> pictures) throws Exception;
    public Picture getById(int id) throws Exception;
    public Picture getPictureByPath(String picture) throws Exception;
    public List<Picture> getList() throws Exception;
    public boolean delete(int id) throws Exception;
    public boolean deleteAll() throws Exception;
}
