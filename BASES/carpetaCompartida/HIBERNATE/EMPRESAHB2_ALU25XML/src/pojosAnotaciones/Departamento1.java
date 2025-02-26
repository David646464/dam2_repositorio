package pojosAnotaciones;

import a.Empregado;
import a.Lugar;
import a.Proxecto;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "DEPARTAMENTO")
public class Departamento1 {
    @Id
    @Column(name = "NumDepartamento", nullable = false)
    private Integer id;

    @Column(name = "NomeDepartamento", nullable = false, length = 25)
    private String nomeDepartamento;

    @Column(name = "NSSDirector", nullable = false, length = 15)
    private String nSSDirector;

    @OneToMany
    private Set<Empregado> empregados = new LinkedHashSet<>();

    @OneToMany
    private Set<Lugar> lugars = new LinkedHashSet<>();

    @OneToMany
    private Set<Proxecto> proxectos = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeDepartamento() {
        return nomeDepartamento;
    }

    public void setNomeDepartamento(String nomeDepartamento) {
        this.nomeDepartamento = nomeDepartamento;
    }

    public String getNSSDirector() {
        return nSSDirector;
    }

    public void setNSSDirector(String nSSDirector) {
        this.nSSDirector = nSSDirector;
    }

    public Set<Empregado> getEmpregados() {
        return empregados;
    }

    public void setEmpregados(Set<Empregado> empregados) {
        this.empregados = empregados;
    }

    public Set<Lugar> getLugars() {
        return lugars;
    }

    public void setLugars(Set<Lugar> lugars) {
        this.lugars = lugars;
    }

    public Set<Proxecto> getProxectos() {
        return proxectos;
    }

    public void setProxectos(Set<Proxecto> proxectos) {
        this.proxectos = proxectos;
    }

}