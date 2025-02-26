package pojosAnotaciones;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Familiar1Id implements java.io.Serializable {
    private static final long serialVersionUID = 2480889967567281816L;
    @Column(name = "NSS_empregado", nullable = false, length = 15)
    private String nssEmpregado;

    @Column(name = "Numero", nullable = false)
    private Short numero;

    public String getNssEmpregado() {
        return nssEmpregado;
    }

    public void setNssEmpregado(String nssEmpregado) {
        this.nssEmpregado = nssEmpregado;
    }

    public Short getNumero() {
        return numero;
    }

    public void setNumero(Short numero) {
        this.numero = numero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Familiar1Id entity = (Familiar1Id) o;
        return Objects.equals(this.nssEmpregado, entity.nssEmpregado) &&
                Objects.equals(this.numero, entity.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nssEmpregado, numero);
    }

}