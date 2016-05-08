package by.bsuir.booking.client.model;

import by.bsuir.booking.client.Util.ParseUtil;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.json.JSONObject;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;

/**
 * Created by User on 09.04.2016.
 */
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User implements Serializable {
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
    private Role roleByIdRole;

    public User(){}

    public User(int idUser, int idRole, String secondName, String firstName, String patronymic, String username, String password, Date dob, byte sex, String passportSeries, int passportN, String identificationN, BigDecimal cash, JSONObject obj) {
        this.idUser = idUser;
        this.idRole = idRole;
        this.secondName = secondName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.username = username;
        this.password = password;
        this.dob = dob;
        this.sex = sex;
        this.passportSeries = passportSeries;
        this.passportN = passportN;
        this.identificationN = identificationN;
        this.cash = cash;
        System.out.println("Constructor User: cash = " + this.cash);
        this.roleByIdRole = new Role(obj.getInt("idRole"), obj.getString("nameRole"));
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String passwordConfirm;

    @JsonIgnore
    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public String getDob() {
        return ParseUtil.parseDateToString(dob);
    }

    public java.util.Date getDobDate() { return dob; }

    public void setDob(String dob) throws ParseException {
        this.dob = ParseUtil.parseStringToDate(dob);
    }

    public void setDobDate(java.util.Date dob) throws ParseException {
        this.dob = dob;
    }

    public byte getSex() {
        return sex;
    }

    public void setSex(byte sex) {
        this.sex = sex;
    }

    public String getPassportSeries() {
        return passportSeries;
    }

    public void setPassportSeries(String passportSeries) {
        this.passportSeries = passportSeries;
    }

    public int getPassportN() {
        return passportN;
    }

    public void setPassportN(int passportN) {
        this.passportN = passportN;
    }

    public String getIdentificationN() {
        return identificationN;
    }

    public void setIdentificationN(String identificationN) {
        this.identificationN = identificationN;
    }

    public BigDecimal getCash() {
        return cash;
    }

    public void setCash(String cash) {
        this.cash = BigDecimal.valueOf(Double.parseDouble(cash));
        System.out.println("setCash User: cash = " + this.cash);
    }
    public void setCash(BigDecimal cash) {
        this.cash = cash;
        System.out.println("setCash User: cash = " + this.cash);
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

    public Role getRoleByIdRole() {
        return roleByIdRole;
    }

    public void setRoleByIdRole(Role roleByIdRole) {
        this.roleByIdRole = roleByIdRole;
    }
}
