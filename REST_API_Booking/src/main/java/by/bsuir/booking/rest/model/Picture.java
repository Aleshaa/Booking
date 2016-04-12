package by.bsuir.booking.rest.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by User on 09.04.2016.
 */
@Entity
@Table(name = "Picture")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Picture {
    private int idPicture;
    private String fileName;
    private String uploadedNname;
    private int width;
    private int height;
    private Collection<Typeroom> typeroomsByIdPicture;

    @Id
    @Column(name = "idPicture", nullable = false, insertable = true, updatable = true)
    public int getIdPicture() {
        return idPicture;
    }

    public void setIdPicture(int idPicture) {
        this.idPicture = idPicture;
    }

    @Basic
    @Column(name = "FileName", nullable = false, insertable = true, updatable = true, length = 45)
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Basic
    @Column(name = "UploadedNname", nullable = false, insertable = true, updatable = true, length = 45)
    public String getUploadedNname() {
        return uploadedNname;
    }

    public void setUploadedNname(String uploadedNname) {
        this.uploadedNname = uploadedNname;
    }

    @Basic
    @Column(name = "Width", nullable = false, insertable = true, updatable = true)
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Basic
    @Column(name = "Height", nullable = false, insertable = true, updatable = true)
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Picture picture = (Picture) o;

        if (idPicture != picture.idPicture) return false;
        if (width != picture.width) return false;
        if (height != picture.height) return false;
        if (fileName != null ? !fileName.equals(picture.fileName) : picture.fileName != null) return false;
        if (uploadedNname != null ? !uploadedNname.equals(picture.uploadedNname) : picture.uploadedNname != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idPicture;
        result = 31 * result + (fileName != null ? fileName.hashCode() : 0);
        result = 31 * result + (uploadedNname != null ? uploadedNname.hashCode() : 0);
        result = 31 * result + width;
        result = 31 * result + height;
        return result;
    }

    @OneToMany(mappedBy = "pictureByIdPicture")
    public Collection<Typeroom> getTyperoomsByIdPicture() {
        return typeroomsByIdPicture;
    }

    public void setTyperoomsByIdPicture(Collection<Typeroom> typeroomsByIdPicture) {
        this.typeroomsByIdPicture = typeroomsByIdPicture;
    }
}
