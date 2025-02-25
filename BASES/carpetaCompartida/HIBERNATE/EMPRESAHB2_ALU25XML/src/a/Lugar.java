package a;

import javax.persistence.*;

@Entity
@Table(name = "LUGAR")
public class Lugar {
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Num_departamento", nullable = false)
    private Departamento numDepartamento;

    @Column(name = "Lugar", nullable = false, length = 15)
    private String lugar;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Departamento getNumDepartamento() {
        return numDepartamento;
    }

    public void setNumDepartamento(Departamento numDepartamento) {
        this.numDepartamento = numDepartamento;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

}