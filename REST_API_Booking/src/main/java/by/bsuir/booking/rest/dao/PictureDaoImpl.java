package by.bsuir.booking.rest.dao;

import by.bsuir.booking.rest.model.Picture;
import by.bsuir.booking.rest.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PictureDaoImpl implements PictureDao{

    @Autowired
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;

    private static final PictureDaoImpl instance = new PictureDaoImpl();

    public PictureDaoImpl(){}

    public static PictureDaoImpl getInstance(){
        return instance;
    }

    @Override
    public boolean add(Picture pic) throws Exception {

        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        session.save(pic);
        tx.commit();
        session.close();

        return false;
    }

    @Override
    public boolean addS(List<Picture> pictures) throws Exception {

        session = sessionFactory.openSession();

        for(Picture pic:pictures) {
            tx = session.beginTransaction();
            session.save(pic);
            tx.commit();
        }
        session.close();

        return false;
    }

    @Override
    public boolean update(Picture picture) throws Exception {
        session = sessionFactory.openSession();
        Picture pic1;
        pic1 = (Picture) session.load(User.class, picture.getIdPicture());
        tx = session.getTransaction();
        pic1 = picture;
        tx = session.beginTransaction();
        session.saveOrUpdate(pic1);
        tx.commit();
        session.close();
        return false;
    }

    @Override
    public boolean updateS(List<Picture> pictures) throws Exception {
        session = sessionFactory.openSession();
        for(Picture picture:pictures) {
            Picture picture1;
            picture1 = (Picture) session.load(User.class, picture.getIdPicture());
            tx = session.getTransaction();
            picture1 = picture;
            tx = session.beginTransaction();
            session.saveOrUpdate(picture1);
            tx.commit();
        }
        session.close();
        return false;
    }

    @Override
    public Picture getById(int id) throws Exception {
        session = sessionFactory.openSession();
        Picture picture = (Picture) session.load(Picture.class, new Integer(id));
        tx = session.getTransaction();
        session.beginTransaction();
        tx.commit();
        return picture;
    }

    @Override
    public Picture getPictureByPath(String picture) throws Exception {
        session = sessionFactory.openSession();
        tx = session.getTransaction();
        session.beginTransaction();
        String hql = "FROM Picture P WHERE P.fileName = :picture";
        Query query = session.createQuery(hql);
        query.setParameter("picture", picture);
        Picture pic = (Picture) query.uniqueResult();
        tx.commit();
        return pic;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Picture> getList() throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        List<Picture> pictures = session.createCriteria(Picture.class).list();
        tx.commit();
        session.close();
        return pictures;
    }

    @Override
    public boolean delete(int id) throws Exception {
        session = sessionFactory.openSession();
        Object o = session.load(Picture.class, id);
        tx = session.getTransaction();
        session.beginTransaction();
        session.delete(o);
        tx.commit();
        return false;
    }

    @Override
    public boolean deleteAll() throws Exception {
        session = sessionFactory.openSession();
        tx = session.getTransaction();
        session.beginTransaction();
        session.createQuery("DELETE FROM Picture").executeUpdate();
        tx.commit();
        return false;
    }
}
