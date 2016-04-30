package by.bsuir.booking.client.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.math.BigDecimal;

//Model Room
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Room {
    private int idRoom;
    private int nRoom;
    private int idTRoom;
    private Typeroom typeroomByIdTRoom;

    public Room(int idRoom, int nRoom, int idTRoom, Typeroom typeroomByIdTRoom) {
        this.idRoom = idRoom;
        this.nRoom = nRoom;
        this.idTRoom = idTRoom;
        this.typeroomByIdTRoom = typeroomByIdTRoom;
    }

    public Room() {
        this.idRoom = 0;
        this.nRoom = 0;
        this.idTRoom = 0;
        this.typeroomByIdTRoom = new Typeroom();
    }

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

    public String getTyperoomByIdTRoom() {
        return typeroomByIdTRoom.getNameTRoom();
    }

    public Typeroom getTyperoomByIdTRoomTR() {
        return typeroomByIdTRoom;
    }

    public void setTyperoomByIdTRoom(String TRoom) {
        System.out.println("TEST GETTING VALUE FROM INPUT " + TRoom);
        typeroomByIdTRoom = new Typeroom(0, TRoom, 0, BigDecimal.valueOf(0.0), 0);
        typeroomByIdTRoom.setNameTRoom(TRoom);
        System.out.println(typeroomByIdTRoom.getNameTRoom());
    }

    public void setTyperoomByIdTRoomTR(Typeroom typeroomByIdTRoom) {
        this.typeroomByIdTRoom = typeroomByIdTRoom;
    }

}
