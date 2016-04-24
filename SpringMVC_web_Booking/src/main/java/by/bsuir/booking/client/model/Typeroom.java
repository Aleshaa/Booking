package by.bsuir.booking.client.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.math.BigDecimal;
import java.util.Collection;

/**
 * Created by User on 09.04.2016.
 */
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Typeroom {
    private int idTRoom;
    private String nameTRoom;
    private int roominess;
    private BigDecimal price;
    private int idPicture;
    private Collection<Room> roomsByIdTRoom;
    private Picture pictureByIdPicture;

    public int getIdTRoom() {
        return idTRoom;
    }

    public void setIdTRoom(int idTRoom) {
        this.idTRoom = idTRoom;
    }

    public String getNameTRoom() {
        return nameTRoom;
    }

    public void setNameTRoom(String nameTRoom) {
        this.nameTRoom = nameTRoom;
    }

    public int getRoominess() {
        return roominess;
    }

    public void setRoominess(int roominess) {
        this.roominess = roominess;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getIdPicture() {
        return idPicture;
    }

    public void setIdPicture(int idPicture) {
        this.idPicture = idPicture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Typeroom typeroom = (Typeroom) o;

        if (idTRoom != typeroom.idTRoom) return false;
        if (roominess != typeroom.roominess) return false;
        if (idPicture != typeroom.idPicture) return false;
        if (nameTRoom != null ? !nameTRoom.equals(typeroom.nameTRoom) : typeroom.nameTRoom != null) return false;
        if (price != null ? !price.equals(typeroom.price) : typeroom.price != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idTRoom;
        result = 31 * result + (nameTRoom != null ? nameTRoom.hashCode() : 0);
        result = 31 * result + roominess;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + idPicture;
        return result;
    }

    public Picture getPictureByIdPicture() {
        return pictureByIdPicture;
    }

    public void setPictureByIdPicture(Picture pictureByIdPicture) {
        this.pictureByIdPicture = pictureByIdPicture;
    }
}
