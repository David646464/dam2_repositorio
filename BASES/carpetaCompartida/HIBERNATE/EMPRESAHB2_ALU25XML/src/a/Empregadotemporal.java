package a;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "EMPREGADOTEMPORAL")
public class Empregadotemporal {
    @Id
    @Column(name = "NSS", nullable = false, length = 15)
    private String nss;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "NSS", nullable = false)
    private Empregado empregado;

    @Column(name = "DataInicio")
    private LocalDate dataInicio;

    @Column(name = "DataFin")
    private LocalDate dataFin;

    @Column(name = "CosteHora")
    private Double costeHora;

    @Column(name = "NumHoras")
    private Double numHoras;

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

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFin() {
        return dataFin;
    }

    public void setDataFin(LocalDate dataFin) {
        this.dataFin = dataFin;
    }

    public Double getCosteHora() {
        return costeHora;
    }

    public void setCosteHora(Double costeHora) {
        this.costeHora = costeHora;
    }

    public Double getNumHoras() {
        return numHoras;
    }

    public void setNumHoras(Double numHoras) {
        this.numHoras = numHoras;
    }

}