package by.bsuir.booking.client.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Created by User on 09.04.2016.
 */
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Role {
    public Role(int idRole, String nameRole) {
        this.idRole = idRole;
        this.nameRole = nameRole;
    }

    private int idRole;
    private String nameRole;

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

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

}
