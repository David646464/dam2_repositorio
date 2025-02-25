package a;

import javax.persistence.*;

@Entity
@Table(name = "EDICIONCURSO_EMPREGADO")
public class EdicioncursoEmpregado {
    @EmbeddedId
    private EdicioncursoEmpregadoId id;

    @MapsId("id")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Edicion edicion;

    @MapsId("nss")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "nss", nullable = false)
    private a.Empregado nss;

    public EdicioncursoEmpregadoId getId() {
        return id;
    }

    public void setId(EdicioncursoEmpregadoId id) {
        this.id = id;
    }

    public Edicion getEdicion() {
        return edicion;
    }

    public void setEdicion(Edicion edicion) {
        this.edicion = edicion;
    }

    public a.Empregado getNss() {
        return nss;
    }

    public void setNss(a.Empregado nss) {
        this.nss = nss;
    }

}