package pojosAnotaciones;

import a.Edicion;
import a.Empregado;

import javax.persistence.*;

@Entity
@Table(name = "EDICIONCURSO_EMPREGADO")
public class EdicioncursoEmpregado1 {
    @EmbeddedId
    private EdicioncursoEmpregado1Id id;

    @MapsId("id")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumns({
            @JoinColumn(name = "Codigo", referencedColumnName = "Codigo", nullable = false),
            @JoinColumn(name = "Numero", referencedColumnName = "Numero", nullable = false)
    })
    private Edicion edicion;

    @MapsId("nss")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "nss", nullable = false)
    private Empregado nss;

    public EdicioncursoEmpregado1Id getId() {
        return id;
    }

    public void setId(EdicioncursoEmpregado1Id id) {
        this.id = id;
    }

    public Edicion getEdicion() {
        return edicion;
    }

    public void setEdicion(Edicion edicion) {
        this.edicion = edicion;
    }

    public Empregado getNss() {
        return nss;
    }

    public void setNss(Empregado nss) {
        this.nss = nss;
    }

}