package by.bsuir.booking.rest.dao;

public class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();
    private DAOFactory(){}
    public static DAOFactory getInstance(){
        return instance;
    }

    public CheckDaoImpl getCheckDao() {
        return CheckDaoImpl.getInstance();
    }

    public PictureDaoImpl getPictureDao() {
        return PictureDaoImpl.getInstance();
    }

    public ReservationDaoImpl getReservationDao() {
        return ReservationDaoImpl.getInstance();
    }

    public RoleDaoImpl getRoleDao() {
        return RoleDaoImpl.getInstance();
    }

    public RoleDaoImpl getRoomDao() {
        return RoleDaoImpl.getInstance();
    }

    public TypeRoomDaoImpl getTRDao() {
        return TypeRoomDaoImpl.getInstance();
    }
    public UserDaoImpl getBusDao() {
        return UserDaoImpl.getInstance();
    }
}
