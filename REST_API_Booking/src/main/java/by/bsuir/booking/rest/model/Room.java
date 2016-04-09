package by.bsuir.booking.rest.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by User on 09.04.2016.
 */
@Entity
public class Room {
    private int idRoom;
    private int nRoom;
    private int idTRoom;
    private Collection<Reservation> reservationsByIdRoom;
    private Typeroom typeroomByIdTRoom;

    @Id
    @Column(name = "idRoom", nullable = false, insertable = true, updatable = true)
    public int getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }

    @Basic
    @Column(name = "NRoom", nullable = false, insertable = true, updatable = true)
    public int getnRoom() {
        return nRoom;
    }

    public void setnRoom(int nRoom) {
        this.nRoom = nRoom;
    }

    @Basic
    @Column(name = "idTRoom", nullable = false, insertable = true, updatable = true)
    public int getIdTRoom() {
        return idTRoom;
    }

    public void setIdTRoom(int idTRoom) {
        this.idTRoom = idTRoom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

        if (idRoom != room.idRoom) return false;
        if (nRoom != room.nRoom) return false;
        if (idTRoom != room.idTRoom) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idRoom;
        result = 31 * result + nRoom;
        result = 31 * result + idTRoom;
        return result;
    }

    @OneToMany(mappedBy = "roomByIdRoom")
    public Collection<Reservation> getReservationsByIdRoom() {
        return reservationsByIdRoom;
    }

    public void setReservationsByIdRoom(Collection<Reservation> reservationsByIdRoom) {
        this.reservationsByIdRoom = reservationsByIdRoom;
    }

    @ManyToOne
    @JoinColumn(name = "idTRoom", referencedColumnName = "idTRoom", nullable = false)
    public Typeroom getTyperoomByIdTRoom() {
        return typeroomByIdTRoom;
    }

    public void setTyperoomByIdTRoom(Typeroom typeroomByIdTRoom) {
        this.typeroomByIdTRoom = typeroomByIdTRoom;
    }
}
