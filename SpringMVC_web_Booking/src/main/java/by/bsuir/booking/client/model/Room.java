package by.bsuir.booking.client.model;

import java.util.Collection;

/**
 * Created by User on 09.04.2016.
 */
public class Room {
    private int idRoom;
    private int nRoom;
    private int idTRoom;
    private Collection<Reservation> reservationsByIdRoom;
    private Typeroom typeroomByIdTRoom;

    public int getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }

    public int getnRoom() {
        return nRoom;
    }

    public void setnRoom(int nRoom) {
        this.nRoom = nRoom;
    }

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

    public Typeroom getTyperoomByIdTRoom() {
        return typeroomByIdTRoom;
    }

    public void setTyperoomByIdTRoom(Typeroom typeroomByIdTRoom) {
        this.typeroomByIdTRoom = typeroomByIdTRoom;
    }
}
