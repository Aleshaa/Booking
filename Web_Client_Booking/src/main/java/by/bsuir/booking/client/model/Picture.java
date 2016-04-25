package by.bsuir.booking.client.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Picture {
    private int idPicture;
    private String fileName;
    private String uploadedNname;
    private int width;
    private int height;

    public Picture(int idPicture, String fileName, String uploadedNname, int width, int height) {
        this.idPicture = idPicture;
        this.fileName = fileName;
        this.uploadedNname = uploadedNname;
        this.width = width;
        this.height = height;
    }

    public int getIdPicture() {
        return idPicture;
    }

    public void setIdPicture(int idPicture) {
        this.idPicture = idPicture;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getUploadedNname() {
        return uploadedNname;
    }

    public void setUploadedNname(String uploadedNname) {
        this.uploadedNname = uploadedNname;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

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

}

