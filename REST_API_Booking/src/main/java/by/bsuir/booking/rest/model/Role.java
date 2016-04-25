package by.bsuir.booking.rest.model;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by User on 09.04.2016.
 */
@Entity
@Table(name = "Role")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Role {
    private int idRole;
    private String nameRole;

    public Role() {
        this.nameRole = "";
        this.idRole = 0;
    }

    private Collection<User> usersByIdRole;

    @Id
    @Column(name = "idRole", nullable = false, insertable = true, updatable = true)
    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    @Basic
    @Column(name = "NameRole", nullable = false, insertable = true, updatable = true, length = 45)
    public String getNameRole() {
        return nameRole;
    }

    public void setNameRole(String nameRole) {
        this.nameRole = nameRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        if (idRole != role.idRole) return false;
        if (nameRole != null ? !nameRole.equals(role.nameRole) : role.nameRole != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idRole;
        result = 31 * result + (nameRole != null ? nameRole.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "roleByIdRole")
    @JsonIgnore
    public Collection<User> getUsersByIdRole() {
        return usersByIdRole;
    }

    public void setUsersByIdRole(Collection<User> usersByIdRole) {
        this.usersByIdRole = usersByIdRole;
    }
}
