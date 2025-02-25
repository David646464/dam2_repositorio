package a;

import javax.persistence.*;

@Entity
@Table(name = "TELEFONO")
public class Telefono {
    @EmbeddedId
    private TelefonoId id;

    @MapsId("nss")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "NSS", nullable = false)
    private Empregado nss;

    @Column(name = "Informacion", length = 26)
    private String informacion;

    public TelefonoId getId() {
        return id;
    }

    public void setId(TelefonoId id) {
        this.id = id;
    }

    public Empregado getNss() {
        return nss;
    }

    public void setNss(Empregado nss) {
        this.nss = nss;
    }

    public String getInformacion() {
        return informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }

}