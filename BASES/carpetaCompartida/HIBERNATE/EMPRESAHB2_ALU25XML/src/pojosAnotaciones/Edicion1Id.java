package pojosAnotaciones;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Edicion1Id implements java.io.Serializable {
    private static final long serialVersionUID = 8593707619639590725L;
    @Column(name = "Codigo", nullable = false)
    private Integer codigo;

    @Column(name = "Numero", nullable = false)
    private Integer numero;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Edicion1Id entity = (Edicion1Id) o;
        return Objects.equals(this.codigo, entity.codigo) &&
                Objects.equals(this.numero, entity.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, numero);
    }

}