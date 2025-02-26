package pojosAnotaciones;

import a.Curso;
import a.Empregado;
import a.Empregadofixo;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "EDICION")
public class Edicion1 {
    @EmbeddedId
    private Edicion1Id id;

    @MapsId("codigo")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Codigo", nullable = false)
    private Curso codigo;

    @Column(name = "Data")
    private LocalDate data;

    @Column(name = "Lugar", length = 25)
    private String lugar;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Profesor", nullable = false)
    private Empregadofixo profesor;

    @ManyToMany
    @JoinTable(name = "EDICIONCURSO_EMPREGADO",
            joinColumns = @JoinColumn(name = "Codigo"),
            inverseJoinColumns = @JoinColumn(name = "nss"))
    private Set<Empregado> empregados = new LinkedHashSet<>();

    public Edicion1Id getId() {
        return id;
    }

    public void setId(Edicion1Id id) {
        this.id = id;
    }

    public Curso getCodigo() {
        return codigo;
    }

    public void setCodigo(Curso codigo) {
        this.codigo = codigo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public Empregadofixo getProfesor() {
        return profesor;
    }

    public void setProfesor(Empregadofixo profesor) {
        this.profesor = profesor;
    }

    public Set<Empregado> getEmpregados() {
        return empregados;
    }

    public void setEmpregados(Set<Empregado> empregados) {
        this.empregados = empregados;
    }

}