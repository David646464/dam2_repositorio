package pojosAnotaciones;

import a.Edicion;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "CURSO")
public class Curso1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Codigo", nullable = false)
    private Integer id;

    @Column(name = "Nome", nullable = false, length = 30)
    private String nome;

    @Column(name = "Horas")
    private Integer horas;

    @OneToMany
    private Set<Edicion> edicions = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getHoras() {
        return horas;
    }

    public void setHoras(Integer horas) {
        this.horas = horas;
    }

    public Set<Edicion> getEdicions() {
        return edicions;
    }

    public void setEdicions(Set<Edicion> edicions) {
        this.edicions = edicions;
    }

}