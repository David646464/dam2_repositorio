package pojosAnotaciones;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class EdicioncursoEmpregado1Id implements java.io.Serializable {
    private static final long serialVersionUID = 252470818079825894L;
    @Column(name = "Codigo", nullable = false)
    private Integer codigo;

    @Column(name = "Numero", nullable = false)
    private Integer numero;

    @Column(name = "nss", nullable = false, length = 15)
    private String nss;

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
        EdicioncursoEmpregado1Id entity = (EdicioncursoEmpregado1Id) o;
        return Objects.equals(this.codigo, entity.codigo) &&
                Objects.equals(this.numero, entity.numero) &&
                Objects.equals(this.nss, entity.nss);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, numero, nss);
    }

}