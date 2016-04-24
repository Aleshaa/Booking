package by.bsuir.booking.client.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.math.BigDecimal;

/**
 * Created by User on 09.04.2016.
 */
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Check_r {
    private int idCheck;
    private int idReserv;
    private BigDecimal payment;
    private Reservation reservationByIdReserv;

    public int getIdCheck() {
        return idCheck;
    }

    public void setIdCheck(int idCheck) {
        this.idCheck = idCheck;
    }

    public int getIdReserv() {
        return idReserv;
    }

    public void setIdReserv(int idReserv) {
        this.idReserv = idReserv;
    }

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

    public Reservation getReservationByIdReserv() {
        return reservationByIdReserv;
    }

    public void setReservationByIdReserv(Reservation reservationByIdReserv) {
        this.reservationByIdReserv = reservationByIdReserv;
    }
}
