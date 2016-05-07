package by.bsuir.booking.rest.services;

import by.bsuir.booking.rest.dao.PictureDao;
import by.bsuir.booking.rest.model.Picture;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PictureServicesImpl implements PictureServices {

    @Autowired
    PictureDao pictureDao;

    @Override
    public boolean addPicture(Picture pic) throws Exception {
        return pictureDao.add(pic);
    }

    @Override
    public boolean addPictures(List<Picture> pictures) throws Exception {
        return pictureDao.addS(pictures);
    }

    @Override
    public boolean updatePicture(Picture picture) throws Exception {
        return pictureDao.update(picture);
    }

    @Override
    public boolean updatePictures(List<Picture> pictures) throws Exception {
        return pictureDao.updateS(pictures);
    }

    @Override
    public Picture getPictureById(int id) throws Exception {
        return pictureDao.getById(id);
    }

    @Override
    public Picture getPictureByPath(String path) throws Exception {
        return pictureDao.getPictureByPath(path);
    }

    @Override
    public List<Picture> getPictureList() throws Exception {
        return pictureDao.getList();
    }

    @Override
    public boolean deletePicture(int id) throws Exception {
        return pictureDao.delete(id);
    }

    @Override
    public boolean deleteAllPictures() throws Exception {
        return pictureDao.deleteAll();
    }
}
