package by.bsuir.booking.rest.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;

/**
 * Created by User on 09.04.2016.
 */
@Entity
@Table(name = "TypeRoom")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Typeroom {
    private int idTRoom;
    private String nameTRoom;
    private int roominess;
    private BigDecimal price;
    private int idPicture;
    private Collection<Room> roomsByIdTRoom;
    private Picture pictureByIdPicture;

    @Id
    @Column(name = "idTRoom", nullable = false, insertable = true, updatable = true)
    public int getIdTRoom() {
        return idTRoom;
    }

    public void setIdTRoom(int idTRoom) {
        this.idTRoom = idTRoom;
    }

    @Basic
    @Column(name = "NameTRoom", nullable = false, insertable = true, updatable = true, length = 45)
    public String getNameTRoom() {
        return nameTRoom;
    }

    public void setNameTRoom(String nameTRoom) {
        this.nameTRoom = nameTRoom;
    }

    @Basic
    @Column(name = "Roominess", nullable = false, insertable = true, updatable = true)
    public int getRoominess() {
        return roominess;
    }

    public void setRoominess(int roominess) {
        this.roominess = roominess;
    }

    @Basic
    @Column(name = "Price", nullable = false, insertable = true, updatable = true, precision = 2)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Basic
    @Column(name = "idPicture", nullable = false, insertable = false, updatable = false)
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

    @OneToMany(mappedBy = "typeroomByIdTRoom")
    public Collection<Room> getRoomsByIdTRoom() {
        return roomsByIdTRoom;
    }

    public void setRoomsByIdTRoom(Collection<Room> roomsByIdTRoom) {
        this.roomsByIdTRoom = roomsByIdTRoom;
    }

    @ManyToOne
    @JoinColumn(name = "idPicture", referencedColumnName = "idPicture", nullable = false)
    public Picture getPictureByIdPicture() {
        return pictureByIdPicture;
    }

    public void setPictureByIdPicture(Picture pictureByIdPicture) {
        this.pictureByIdPicture = pictureByIdPicture;
    }
}
