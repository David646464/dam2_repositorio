package a;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DEPARTAMENTO")
public class Departamento {
    @Id
    @Column(name = "NumDepartamento", nullable = false)
    private Integer id;

    @Column(name = "NomeDepartamento", nullable = false, length = 25)
    private String nomeDepartamento;

    @Column(name = "NSSDirector", nullable = false, length = 15)
    private String nSSDirector;

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

}