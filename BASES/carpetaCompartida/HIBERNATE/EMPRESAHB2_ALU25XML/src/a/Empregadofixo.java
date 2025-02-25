package a;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "EMPREGADOFIXO")
public class Empregadofixo {
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

}