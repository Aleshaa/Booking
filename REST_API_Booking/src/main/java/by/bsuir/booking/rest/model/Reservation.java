package by.bsuir.booking.rest.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * Created by User on 09.04.2016.
 */
@Entity
@Table(name = "Reservation")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Reservation {
    private int idReserv;
    private int idUser;
    private int idRoom;
    private java.util.Date checkInDate;
    private java.util.Date checkOutDate;
    private byte complete;
    private float interestPayment;
    private byte arrived;
    private Room roomByIdRoom;
    private User userByIdUser;
    //private Collection<Check_r> checksByIdReserv;

    @Id
    @Column(name = "idReserv", nullable = false, insertable = true, updatable = true)
    public int getIdReserv() {
        return idReserv;
    }

    public void setIdReserv(int idReserv) {
        this.idReserv = idReserv;
    }

    @Basic
    @Column(name = "idUser", nullable = false, insertable = false, updatable = false)
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Basic
    @Column(name = "idRoom", nullable = false, insertable = false, updatable = false)
    public int getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "Check_inDate", nullable = false, insertable = true, updatable = true)
    public java.util.Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(java.util.Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "Check_outDate", nullable = false, insertable = true, updatable = true)
    public java.util.Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(java.util.Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    @Basic
    @Column(name = "Complete", nullable = false, insertable = true, updatable = true)
    public byte getComplete() {
        return complete;
    }

    public void setComplete(byte complete) {
        this.complete = complete;
    }

    @Basic
    @Column(name = "InterestPayment", nullable = false, insertable = true, updatable = true, precision = 0)
    public float getInterestPayment() {
        return interestPayment;
    }

    public void setInterestPayment(float interestPayment) {
        this.interestPayment = interestPayment;
    }

    @Basic
    @Column(name = "Arrived", nullable = false, insertable = true, updatable = true)
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

    @ManyToOne
    @JoinColumn(name = "idRoom", referencedColumnName = "idRoom", nullable = false)
    public Room getRoomByIdRoom() {
        return roomByIdRoom;
    }

    public void setRoomByIdRoom(Room roomByIdRoom) {
        this.roomByIdRoom = roomByIdRoom;
    }

    @ManyToOne
    @JoinColumn(name = "idUser", referencedColumnName = "idUser", nullable = false)
    public User getUserByIdUser() {
        return userByIdUser;
    }

    public void setUserByIdUser(User userByIdUser) {
        this.userByIdUser = userByIdUser;
    }

    /*@OneToMany(mappedBy = "reservationByIdReserv")
    @JsonIgnore
    public Collection<Check_r> getChecksByIdReserv() {
        return checksByIdReserv;
    }

    public void setChecksByIdReserv(Collection<Check_r> checksByIdReserv) {
        this.checksByIdReserv = checksByIdReserv;
    }*/
}
