package by.bsuir.booking.rest.services;

import by.bsuir.booking.rest.dao.PictureDao;
import by.bsuir.booking.rest.model.Picture;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by User on 11.04.2016.
 */
public class PictureServicesImpl implements PictureServices {

    @Autowired
    PictureDao pictureDao;

    @Override
    public boolean addPicture(Picture pic) throws Exception {
        return pictureDao.addPicture(pic);
    }

    @Override
    public boolean addPictures(List<Picture> pictures) throws Exception {
        return pictureDao.addPictures(pictures);
    }

    @Override
    public boolean updatePicture(Picture picture) throws Exception {
        return pictureDao.updatePicture(picture);
    }

    @Override
    public boolean updatePictures(List<Picture> pictures) throws Exception {
        return pictureDao.updatePictures(pictures);
    }

    @Override
    public Picture getPictureById(int id) throws Exception {
        return pictureDao.getPictureById(id);
    }

    @Override
    public List<Picture> getPictureList() throws Exception {
        return pictureDao.getPictureList();
    }

    @Override
    public boolean deletePicture(int id) throws Exception {
        return pictureDao.deletePicture(id);
    }

    @Override
    public boolean deleteAllPictures() throws Exception {
        return pictureDao.deleteAllPictures();
    }
}
