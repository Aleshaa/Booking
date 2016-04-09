package by.bsuir.booking.rest.model;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by User on 09.04.2016.
 */
@Entity
public class —heck {
    private int id—heck;
    private int idReserv;
    private BigDecimal payment;
    private Reservation reservationByIdReserv;

    @Id
    @Column(name = "id—heck", nullable = false, insertable = true, updatable = true)
    public int getId—heck() {
        return id—heck;
    }

    public void setId—heck(int id—heck) {
        this.id—heck = id—heck;
    }

    @Basic
    @Column(name = "idReserv", nullable = false, insertable = true, updatable = true)
    public int getIdReserv() {
        return idReserv;
    }

    public void setIdReserv(int idReserv) {
        this.idReserv = idReserv;
    }

    @Basic
    @Column(name = "Payment", nullable = false, insertable = true, updatable = true, precision = 2)
    public BigDecimal getPayment() {
        return payment;
    }

    public void setPayment(BigDecimal payment) {
        this.payment = payment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        —heck Òheck = (—heck) o;

        if (id—heck != Òheck.id—heck) return false;
        if (idReserv != Òheck.idReserv) return false;
        if (payment != null ? !payment.equals(Òheck.payment) : Òheck.payment != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id—heck;
        result = 31 * result + idReserv;
        result = 31 * result + (payment != null ? payment.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "idReserv", referencedColumnName = "idReserv", nullable = false)
    public Reservation getReservationByIdReserv() {
        return reservationByIdReserv;
    }

    public void setReservationByIdReserv(Reservation reservationByIdReserv) {
        this.reservationByIdReserv = reservationByIdReserv;
    }
}
