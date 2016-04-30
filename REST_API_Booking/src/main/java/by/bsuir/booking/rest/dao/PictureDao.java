package by.bsuir.booking.rest.dao;

import by.bsuir.booking.rest.model.Picture;

import java.util.List;

/**
 * Created by User on 11.04.2016.
 */
public interface PictureDao {
    public boolean addPicture(Picture pic) throws Exception;
    public boolean addPictures(List<Picture> pictures) throws Exception;
    public boolean updatePicture(Picture picture) throws Exception;
    public boolean updatePictures(List<Picture> pictures) throws Exception;
    public Picture getPictureById(int id) throws Exception;
    public Picture getPictureByPath(String picture) throws Exception;
    public List<Picture> getPictureList() throws Exception;
    public boolean deletePicture(int id) throws Exception;
    public boolean deleteAllPictures() throws Exception;
}
