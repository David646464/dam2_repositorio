package pojosAnotaciones;

import a.Empregado;
import a.Proxecto;

import javax.persistence.*;

@Entity
@Table(name = "EMPREGADO_PROXECTO")
public class EmpregadoProxecto1 {
    @EmbeddedId
    private EmpregadoProxecto1Id id;

    @MapsId("nSSEmpregado")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "NSSEmpregado", nullable = false)
    private Empregado nSSEmpregado;

    @MapsId("numProxecto")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "NumProxecto", nullable = false)
    private Proxecto numProxecto;

    @Column(name = "Horas")
    private Integer horas;

    public EmpregadoProxecto1Id getId() {
        return id;
    }

    public void setId(EmpregadoProxecto1Id id) {
        this.id = id;
    }

    public Empregado getNSSEmpregado() {
        return nSSEmpregado;
    }

    public void setNSSEmpregado(Empregado nSSEmpregado) {
        this.nSSEmpregado = nSSEmpregado;
    }

    public Proxecto getNumProxecto() {
        return numProxecto;
    }

    public void setNumProxecto(Proxecto numProxecto) {
        this.numProxecto = numProxecto;
    }

    public Integer getHoras() {
        return horas;
    }

    public void setHoras(Integer horas) {
        this.horas = horas;
    }

}