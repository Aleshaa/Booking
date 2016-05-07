package by.bsuir.booking.rest.model;

import by.bsuir.booking.rest.observer.Observer;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;


@Entity
@Table(name = "User")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User implements Serializable, Observer {

    private int idUser;
    private int idRole;
    private String secondName;
    private String firstName;
    private String patronymic;
    private String username;
    private String password;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private java.util.Date dob;
    private byte sex;
    private String passportSeries;
    private int passportN;
    private String identificationN;
    private BigDecimal cash;
    private Collection<Reservation> reservationsByIdUser;

    public User() {
        this.idUser = 0;
        this.idRole = 0;
        this.secondName = "";
        this.firstName = "";
        this.patronymic = "";
        this.username = "";
        this.password = "";
        this.dob = new Date();
        this.sex = 0;
        this.passportSeries = "";
        this.passportN = 0;
        this.identificationN = "";
        this.cash = BigDecimal.valueOf(0.0);
        this.roleByIdRole = new Role();
    }

    private Role roleByIdRole;

    @Id
    @Column(name = "idUser", nullable = false, insertable = true, updatable = true)
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Basic
    @Column(name = "idRole", nullable = false, insertable = false, updatable = false)
    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    @Basic
    @Column(name = "SecondName", nullable = false, insertable = true, updatable = true, length = 45)
    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Basic
    @Column(name = "FirstName", nullable = false, insertable = true, updatable = true, length = 45)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "Patronymic", nullable = false, insertable = true, updatable = true, length = 45)
    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    @Basic
    @Column(name = "Username", nullable = false, insertable = true, updatable = true, length = 45)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "Password", nullable = false, insertable = true, updatable = true, length = 45)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "DOB", nullable = false, insertable = true, updatable = true)
    public java.util.Date getDob() {
        return dob;
    }

    public void setDob(java.util.Date dob) {
        this.dob = dob;
    }

    @Basic
    @Column(name = "Sex", nullable = false, insertable = true, updatable = true)
    public byte getSex() {
        return sex;
    }

    public void setSex(byte sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "PassportSeries", nullable = false, insertable = true, updatable = true, length = 45)
    public String getPassportSeries() {
        return passportSeries;
    }

    public void setPassportSeries(String passportSeries) {
        this.passportSeries = passportSeries;
    }

    @Basic
    @Column(name = "PassportN", nullable = false, insertable = true, updatable = true)
    public int getPassportN() {
        return passportN;
    }

    public void setPassportN(int passportN) {
        this.passportN = passportN;
    }

    @Basic
    @Column(name = "IdentificationN", nullable = false, insertable = true, updatable = true, length = 45)
    public String getIdentificationN() {
        return identificationN;
    }

    public void setIdentificationN(String identificationN) {
        this.identificationN = identificationN;
    }

    @Basic
    @Column(name = "Cash", nullable = false, insertable = true, updatable = true, precision = 30)
    public BigDecimal getCash() {
        return cash;
    }

    public void setCash(BigDecimal cash) {
        this.cash = cash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (idUser != user.idUser) return false;
        if (idRole != user.idRole) return false;
        if (sex != user.sex) return false;
        if (passportN != user.passportN) return false;
        if (secondName != null ? !secondName.equals(user.secondName) : user.secondName != null) return false;
        if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null) return false;
        if (patronymic != null ? !patronymic.equals(user.patronymic) : user.patronymic != null) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (dob != null ? !dob.equals(user.dob) : user.dob != null) return false;
        if (passportSeries != null ? !passportSeries.equals(user.passportSeries) : user.passportSeries != null)
            return false;
        if (identificationN != null ? !identificationN.equals(user.identificationN) : user.identificationN != null)
            return false;
        if (cash != null ? !cash.equals(user.cash) : user.cash != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idUser;
        result = 31 * result + idRole;
        result = 31 * result + (secondName != null ? secondName.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (patronymic != null ? patronymic.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (dob != null ? dob.hashCode() : 0);
        result = 31 * result + (int) sex;
        result = 31 * result + (passportSeries != null ? passportSeries.hashCode() : 0);
        result = 31 * result + passportN;
        result = 31 * result + (identificationN != null ? identificationN.hashCode() : 0);
        result = 31 * result + (cash != null ? cash.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "userByIdUser")
    @JsonIgnore
    public Collection<Reservation> getReservationsByIdUser() {
        return reservationsByIdUser;
    }

    public void setReservationsByIdUser(Collection<Reservation> reservationsByIdUser) {
        this.reservationsByIdUser = reservationsByIdUser;
    }

    @ManyToOne
    @JoinColumn(name = "idRole", referencedColumnName = "idRole", nullable = false)
    public Role getRoleByIdRole() {
        return roleByIdRole;
    }

    public void setRoleByIdRole(Role roleByIdRole) {
        this.roleByIdRole = roleByIdRole;
    }

}
