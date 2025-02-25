package a;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "EMPREGADO")
public class Empregado {
    @Id
    @Column(name = "NSS", nullable = false, length = 15)
    private String nss;

    @Column(name = "Nome", nullable = false, length = 25)
    private String nome;

    @Column(name = "Apelido1", nullable = false, length = 25)
    private String apelido1;

    @Column(name = "Apelido2", length = 25)
    private String apelido2;

    @Column(name = "Rua", length = 30)
    private String rua;

    @Column(name = "Numero_Calle")
    private Integer numeroCalle;

    @Column(name = "Piso", length = 4)
    private String piso;

    @Column(name = "CP", length = 5)
    private String cp;

    @Column(name = "Localidade", length = 25)
    private String localidade;

    @Column(name = "Provincia", length = 15)
    private String provincia;

    @Column(name = "DataNacemento")
    private Instant dataNacemento;

    @Column(name = "Sexo")
    private Character sexo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NSSSupervisa")
    private Empregado nSSSupervisa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NumDepartamentoPertenece")
    private Departamento numDepartamentoPertenece;

    public String getNss() {
        return nss;
    }

    public void setNss(String nss) {
        this.nss = nss;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido1() {
        return apelido1;
    }

    public void setApelido1(String apelido1) {
        this.apelido1 = apelido1;
    }

    public String getApelido2() {
        return apelido2;
    }

    public void setApelido2(String apelido2) {
        this.apelido2 = apelido2;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Integer getNumeroCalle() {
        return numeroCalle;
    }

    public void setNumeroCalle(Integer numeroCalle) {
        this.numeroCalle = numeroCalle;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public Instant getDataNacemento() {
        return dataNacemento;
    }

    public void setDataNacemento(Instant dataNacemento) {
        this.dataNacemento = dataNacemento;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public Empregado getNSSSupervisa() {
        return nSSSupervisa;
    }

    public void setNSSSupervisa(Empregado nSSSupervisa) {
        this.nSSSupervisa = nSSSupervisa;
    }

    public Departamento getNumDepartamentoPertenece() {
        return numDepartamentoPertenece;
    }

    public void setNumDepartamentoPertenece(Departamento numDepartamentoPertenece) {
        this.numDepartamentoPertenece = numDepartamentoPertenece;
    }

}