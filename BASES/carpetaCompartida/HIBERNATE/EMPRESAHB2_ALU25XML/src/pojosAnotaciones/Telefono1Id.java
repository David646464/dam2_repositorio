package pojosAnotaciones;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Telefono1Id implements java.io.Serializable {
    private static final long serialVersionUID = -429243847438306186L;
    @Column(name = "NSS", nullable = false, length = 15)
    private String nss;

    @Column(name = "Telefono", nullable = false, length = 9)
    private String telefono;

    public String getNss() {
        return nss;
    }

    public void setNss(String nss) {
        this.nss = nss;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Telefono1Id entity = (Telefono1Id) o;
        return Objects.equals(this.telefono, entity.telefono) &&
                Objects.equals(this.nss, entity.nss);
    }

    @Override
    public int hashCode() {
        return Objects.hash(telefono, nss);
    }

}