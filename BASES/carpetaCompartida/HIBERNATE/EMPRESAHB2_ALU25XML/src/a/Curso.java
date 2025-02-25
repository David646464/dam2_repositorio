package a;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CURSO")
public class Curso {
    @Id
    @Column(name = "Codigo", nullable = false)
    private Integer id;

    @Column(name = "Nome", nullable = false, length = 30)
    private String nome;

    @Column(name = "Horas")
    private Integer horas;

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

}