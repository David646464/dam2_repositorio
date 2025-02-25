package a;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "VEHICULO")
public class Vehiculo {
    @Id
    @Column(name = "NSS", nullable = false, length = 15)
    private String nss;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "NSS", nullable = false)
    private Empregado empregado;

    @Column(name = "Matricula", length = 10)
    private String matricula;

    @Column(name = "Marca", length = 15)
    private String marca;

    @Column(name = "Modelo", length = 25)
    private String modelo;

    @Column(name = "DataCompra")
    private LocalDate dataCompra;

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

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
    }

}