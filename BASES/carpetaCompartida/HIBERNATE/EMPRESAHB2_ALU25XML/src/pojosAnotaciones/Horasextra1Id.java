package pojosAnotaciones;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDate;
import java.util.Objects;

@Embeddable
public class Horasextra1Id implements java.io.Serializable {
    private static final long serialVersionUID = -1566546846491918127L;
    @Column(name = "Data", nullable = false)
    private LocalDate data;

    @Column(name = "NSS", nullable = false, length = 15)
    private String nss;

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getNss() {
        return nss;
    }

    public void setNss(String nss) {
        this.nss = nss;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Horasextra1Id entity = (Horasextra1Id) o;
        return Objects.equals(this.data, entity.data) &&
                Objects.equals(this.nss, entity.nss);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, nss);
    }

}