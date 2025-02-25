package a;

import javax.persistence.*;

@Entity
@Table(name = "EMPREGADO_PROXECTO")
public class EmpregadoProxecto {
    @EmbeddedId
    private EmpregadoProxectoId id;

    @MapsId("nSSEmpregado")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "NSSEmpregado", nullable = false)
    private Empregado nSSEmpregado;

    @MapsId("numProxecto")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "NumProxecto", nullable = false)
    private a.Proxecto numProxecto;

    @Column(name = "Horas")
    private Integer horas;

    public EmpregadoProxectoId getId() {
        return id;
    }

    public void setId(EmpregadoProxectoId id) {
        this.id = id;
    }

    public Empregado getNSSEmpregado() {
        return nSSEmpregado;
    }

    public void setNSSEmpregado(Empregado nSSEmpregado) {
        this.nSSEmpregado = nSSEmpregado;
    }

    public a.Proxecto getNumProxecto() {
        return numProxecto;
    }

    public void setNumProxecto(a.Proxecto numProxecto) {
        this.numProxecto = numProxecto;
    }

    public Integer getHoras() {
        return horas;
    }

    public void setHoras(Integer horas) {
        this.horas = horas;
    }

}