package pojosAnotaciones;

import a.*;

import javax.persistence.*;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "EMPREGADO")
public class Empregado1 {
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

    @ManyToMany
    @JoinTable(name = "EDICIONCURSO_EMPREGADO",
            joinColumns = @JoinColumn(name = "nss"),
            inverseJoinColumns = @JoinColumn(name = "Codigo"))
    private Set<Edicion> edicions = new LinkedHashSet<>();

    @OneToMany
    private Set<Empregado> empregados = new LinkedHashSet<>();

    @OneToOne
    private Empregadofixo empregadofixo;

    @OneToOne
    private Empregadotemporal empregadotemporal;

    @OneToMany
    private Set<EmpregadoProxecto> empregadoProxectos = new LinkedHashSet<>();

    @OneToMany
    private Set<Familiar> familiars = new LinkedHashSet<>();

    @OneToMany
    private Set<Telefono> telefonos = new LinkedHashSet<>();

    @OneToOne
    private Vehiculo vehiculo;

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

    public Set<Edicion> getEdicions() {
        return edicions;
    }

    public void setEdicions(Set<Edicion> edicions) {
        this.edicions = edicions;
    }

    public Set<Empregado> getEmpregados() {
        return empregados;
    }

    public void setEmpregados(Set<Empregado> empregados) {
        this.empregados = empregados;
    }

    public Empregadofixo getEmpregadofixo() {
        return empregadofixo;
    }

    public void setEmpregadofixo(Empregadofixo empregadofixo) {
        this.empregadofixo = empregadofixo;
    }

    public Empregadotemporal getEmpregadotemporal() {
        return empregadotemporal;
    }

    public void setEmpregadotemporal(Empregadotemporal empregadotemporal) {
        this.empregadotemporal = empregadotemporal;
    }

    public Set<EmpregadoProxecto> getEmpregadoProxectos() {
        return empregadoProxectos;
    }

    public void setEmpregadoProxectos(Set<EmpregadoProxecto> empregadoProxectos) {
        this.empregadoProxectos = empregadoProxectos;
    }

    public Set<Familiar> getFamiliars() {
        return familiars;
    }

    public void setFamiliars(Set<Familiar> familiars) {
        this.familiars = familiars;
    }

    public Set<Telefono> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(Set<Telefono> telefonos) {
        this.telefonos = telefonos;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

}