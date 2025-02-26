package pojosAnotaciones;

import a.Empregadofixo;

import javax.persistence.*;

@Entity
@Table(name = "HORASEXTRAS")
public class Horasextra1 {
    @EmbeddedId
    private Horasextra1Id id;

    @MapsId("nss")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "NSS", nullable = false)
    private Empregadofixo nss;

    @Column(name = "HorasExtras")
    private Double horasExtras;

    public Horasextra1Id getId() {
        return id;
    }

    public void setId(Horasextra1Id id) {
        this.id = id;
    }

    public Empregadofixo getNss() {
        return nss;
    }

    public void setNss(Empregadofixo nss) {
        this.nss = nss;
    }

    public Double getHorasExtras() {
        return horasExtras;
    }

    public void setHorasExtras(Double horasExtras) {
        this.horasExtras = horasExtras;
    }

}