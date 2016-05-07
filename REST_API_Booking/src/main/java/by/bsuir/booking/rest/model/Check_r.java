package by.bsuir.booking.rest.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Check_r")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Check_r {
    private int idCheck;
    private int idReserv;
    private BigDecimal payment;
    private Reservation reservationByIdReserv;

    @Id
    @Column(name = "idCheck", nullable = false, insertable = true, updatable = true)
    public int getIdCheck() {
        return idCheck;
    }

    public void setIdCheck(int idCheck) {
        this.idCheck = idCheck;
    }

    @Basic
    @Column(name = "idReserv", nullable = false, insertable = false, updatable = false)
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

        Check_r check = (Check_r) o;

        if (idCheck != check.idCheck) return false;
        if (idReserv != check.idReserv) return false;
        if (payment != null ? !payment.equals(check.payment) : check.payment != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCheck;
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
