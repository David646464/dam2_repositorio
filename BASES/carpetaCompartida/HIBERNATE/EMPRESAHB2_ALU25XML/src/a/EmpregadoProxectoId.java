package a;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class EmpregadoProxectoId implements java.io.Serializable {
    private static final long serialVersionUID = 1622477409236154966L;
    @Column(name = "NSSEmpregado", nullable = false, length = 15)
    private String nSSEmpregado;

    @Column(name = "NumProxecto", nullable = false)
    private Integer numProxecto;

    public String getNSSEmpregado() {
        return nSSEmpregado;
    }

    public void setNSSEmpregado(String nSSEmpregado) {
        this.nSSEmpregado = nSSEmpregado;
    }

    public Integer getNumProxecto() {
        return numProxecto;
    }

    public void setNumProxecto(Integer numProxecto) {
        this.numProxecto = numProxecto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        EmpregadoProxectoId entity = (EmpregadoProxectoId) o;
        return Objects.equals(this.numProxecto, entity.numProxecto) &&
                Objects.equals(this.nSSEmpregado, entity.nSSEmpregado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numProxecto, nSSEmpregado);
    }

}