package by.bsuir.booking.client.model;

import by.bsuir.booking.client.Util.ParseUtil;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.ParseException;
import java.util.Date;

//Model Reservation
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Reservation {
    private int idReserv;
    private int idUser;
    private int idRoom;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private java.util.Date checkInDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private java.util.Date checkOutDate;
    private byte complete;
    private float interestPayment;
    private byte arrived;
    private Room roomByIdRoom;
    private User userByIdUser;

    public Reservation(int idReserv, int idUser, int idRoom, Date checkInDate, Date checkOutDate, byte complete, float interestPayment, byte arrived, Room roomByIdRoom, User userByIdUser) {
        this.idReserv = idReserv;
        this.idUser = idUser;
        this.idRoom = idRoom;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.complete = complete;
        this.interestPayment = interestPayment;
        this.arrived = arrived;
        this.roomByIdRoom = roomByIdRoom;
        this.userByIdUser = userByIdUser;
    }

    public Reservation() {

    }

    public int getIdReserv() {
        return idReserv;
    }

    public void setIdReserv(int idReserv) {
        this.idReserv = idReserv;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }

    public String getCheckInDate() {
        return ParseUtil.parseDateToString(checkInDate);
    }
    public java.util.Date getCheckInDateR() {
        return checkInDate;
    }
    public long getCheckInDateL(){ return  checkInDate.getTime();}

    public String getCheckInDateStr() {
        return ParseUtil.parseDateToString(checkInDate);
    }


    public void setCheckInDate(String checkInDate) throws ParseException {
        this.checkInDate = ParseUtil.parseStringToDate(checkInDate);
    }

    public void setCheckInDateR(java.util.Date checkInDate) {
        this.checkInDate = checkInDate;
    }


    public String getCheckOutDate() {
        return ParseUtil.parseDateToString(checkOutDate);
    }
    public java.util.Date getCheckOutDateR() {
        return checkOutDate;
    }
    public long getCheckOutDateL() {
        return checkOutDate.getTime();
    }


    public String getCheckOutDateStr() {
        return ParseUtil.parseDateToString(checkOutDate);
    }


    public void setCheckOutDate(String checkOutDate) throws ParseException {
        this.checkOutDate = ParseUtil.parseStringToDate(checkOutDate);
    }

    public void setCheckOutDateR(java.util.Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }


    public byte getComplete() {
        return complete;
    }

    public void setComplete(byte complete) {
        this.complete = complete;
    }

    public float getInterestPayment() {
        return interestPayment;
    }

    public void setInterestPayment(float interestPayment) {
        this.interestPayment = interestPayment;
    }

    public byte getArrived() {
        return arrived;
    }

    public void setArrived(byte arrived) {
        this.arrived = arrived;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reservation that = (Reservation) o;

        if (idReserv != that.idReserv) return false;
        if (idUser != that.idUser) return false;
        if (idRoom != that.idRoom) return false;
        if (complete != that.complete) return false;
        if (Float.compare(that.interestPayment, interestPayment) != 0) return false;
        if (arrived != that.arrived) return false;
        if (checkInDate != null ? !checkInDate.equals(that.checkInDate) : that.checkInDate != null) return false;
        if (checkOutDate != null ? !checkOutDate.equals(that.checkOutDate) : that.checkOutDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idReserv;
        result = 31 * result + idUser;
        result = 31 * result + idRoom;
        result = 31 * result + (checkInDate != null ? checkInDate.hashCode() : 0);
        result = 31 * result + (checkOutDate != null ? checkOutDate.hashCode() : 0);
        result = 31 * result + (int) complete;
        result = 31 * result + (interestPayment != +0.0f ? Float.floatToIntBits(interestPayment) : 0);
        result = 31 * result + (int) arrived;
        return result;
    }

    public String getRoomByIdRoom() {
        return Integer.toString(roomByIdRoom.getnRoom());
    }

    public void setRoomByIdRoom(String roomByIdRoom) {
        this.roomByIdRoom = new Room(0, Integer.parseInt(roomByIdRoom), 0, null);
    }

    public Room getRoomByIdRoomR() {
        return roomByIdRoom;
    }

    public void setRoomByIdRoomR(Room roomByIdRoom) {
        this.roomByIdRoom = roomByIdRoom;
    }

    public User getUserByIdUser() {
        return userByIdUser;
    }

    public void setUserByIdUser(User userByIdUser) {
        this.userByIdUser = userByIdUser;
    }
}
