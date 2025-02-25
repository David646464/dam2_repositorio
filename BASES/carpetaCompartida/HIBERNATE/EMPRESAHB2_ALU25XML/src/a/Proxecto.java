package a;

import javax.persistence.*;

@Entity
@Table(name = "PROXECTO")
public class Proxecto {
    @Id
    @Column(name = "NumProxecto", nullable = false)
    private Integer id;

    @Column(name = "NomeProxecto", nullable = false, length = 25)
    private String nomeProxecto;

    @Column(name = "Lugar", nullable = false, length = 25)
    private String lugar;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "NumDepartControla", nullable = false)
    private Departamento numDepartControla;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeProxecto() {
        return nomeProxecto;
    }

    public void setNomeProxecto(String nomeProxecto) {
        this.nomeProxecto = nomeProxecto;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public Departamento getNumDepartControla() {
        return numDepartControla;
    }

    public void setNumDepartControla(Departamento numDepartControla) {
        this.numDepartControla = numDepartControla;
    }

}