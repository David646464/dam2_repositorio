package Pojos;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@Embeddable
public class Familiar implements Serializable {

    @Column(name = "Numero", nullable = false)
    private int numero;

    @Column(name = "NSS", length = 15, nullable = false)
    private String NSS;

    @Column(name = "nome", length = 25, nullable = false)
    private String nome;

    @Column(name = "apelido1", length = 25, nullable = false)
    private String apelido1;

    @Column(name = "apelido2", length = 25)
    private String apelido2;

    @Column(name = "DataNacemento")
    @Temporal(TemporalType.DATE)
    private Date dataNacemento;

    @Column(name = "parentesco", length = 20, nullable = false)
    private String parentesco;

    @Column(name = "sexo", length = 1, nullable = false)
    private Character sexo;

    public Familiar() {
    }

    public Familiar(String NSS, String nome, String apelido1, String apelido2, Date dataNacemento, String parentesco, Character sexo) {
        this.NSS = NSS;
        this.nome = nome;
        this.apelido1 = apelido1;
        this.apelido2 = apelido2;
        this.dataNacemento = dataNacemento;
        this.parentesco = parentesco;
        this.sexo = sexo;
    }

    public String getNSS() {
        return NSS;
    }

    public void setNSS(String NSS) {
        this.NSS = NSS;
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

    public Date getDataNacemento() {
        return dataNacemento;
    }

    public void setDataNacemento(Date dataNacemento) {
        this.dataNacemento = dataNacemento;
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

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
