package pojosAnotaciones;

import a.Edicion;
import a.Empregado;
import a.Horasextra;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "EMPREGADOFIXO")
public class Empregadofixo1 {
    @Id
    @Column(name = "NSS", nullable = false, length = 15)
    private String nss;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "NSS", nullable = false)
    private Empregado empregado;

    @Column(name = "Salario")
    private Double salario;

    @Column(name = "DataAlta")
    private LocalDate dataAlta;

    @Column(name = "Categoria", length = 20)
    private String categoria;

    @OneToMany
    private Set<Edicion> edicions = new LinkedHashSet<>();

    @OneToMany
    private Set<Horasextra> horasextras = new LinkedHashSet<>();

    public String getNss() {
        return nss;
    }

    public void setNss(String nss) {
        this.nss = nss;
    }

    public Empregado getEmpregado() {
        return empregado;
    }

    public void setEmpregado(Empregado empregado) {
        this.empregado = empregado;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public LocalDate getDataAlta() {
        return dataAlta;
    }

    public void setDataAlta(LocalDate dataAlta) {
        this.dataAlta = dataAlta;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Set<Edicion> getEdicions() {
        return edicions;
    }

    public void setEdicions(Set<Edicion> edicions) {
        this.edicions = edicions;
    }

    public Set<Horasextra> getHorasextras() {
        return horasextras;
    }

    public void setHorasextras(Set<Horasextra> horasextras) {
        this.horasextras = horasextras;
    }

}