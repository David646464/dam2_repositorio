package pojosAnotaciones;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Dtproperty1Id implements java.io.Serializable {
    private static final long serialVersionUID = 1873321973281265519L;
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "property", nullable = false, length = 64)
    private String property;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Dtproperty1Id entity = (Dtproperty1Id) o;
        return Objects.equals(this.property, entity.property) &&
                Objects.equals(this.id, entity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(property, id);
    }

}