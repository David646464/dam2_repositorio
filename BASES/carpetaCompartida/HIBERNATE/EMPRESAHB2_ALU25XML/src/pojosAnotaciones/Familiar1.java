package pojosAnotaciones;

import a.Empregado;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "FAMILIAR")
public class Familiar1 {
    @EmbeddedId
    private Familiar1Id id;

    @MapsId("nssEmpregado")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "NSS_empregado", nullable = false)
    private Empregado nssEmpregado;

    @Column(name = "NSS", nullable = false, length = 15)
    private String nss;

    @Column(name = "Nome", nullable = false, length = 25)
    private String nome;

    @Column(name = "Apelido1", nullable = false, length = 25)
    private String apelido1;

    @Column(name = "Apelido2", length = 25)
    private String apelido2;

    @Column(name = "Data_nacimento")
    private Instant dataNacimento;

    @Column(name = "Parentesco", nullable = false, length = 20)
    private String parentesco;

    @Column(name = "Sexo", nullable = false)
    private Character sexo;

    public Familiar1Id getId() {
        return id;
    }

    public void setId(Familiar1Id id) {
        this.id = id;
    }

    public Empregado getNssEmpregado() {
        return nssEmpregado;
    }

    public void setNssEmpregado(Empregado nssEmpregado) {
        this.nssEmpregado = nssEmpregado;
    }

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

    public Instant getDataNacimento() {
        return dataNacimento;
    }

    public void setDataNacimento(Instant dataNacimento) {
        this.dataNacimento = dataNacimento;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

}