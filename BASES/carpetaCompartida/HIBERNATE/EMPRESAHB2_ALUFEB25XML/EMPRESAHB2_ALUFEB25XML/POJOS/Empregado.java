package POJOS;
// Generated 09-feb-2023 8:57:23 by Hibernate Tools 3.6.0

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Empregado generated by hbm2java
 */
public class Empregado implements java.io.Serializable {

    private String nss;
    private String nome;
    private String apelido1;
    private String apelido2;
    private Date dataNacemento;
    private Character sexo;
    private Enderezo enderezo;
    //se guardamos el superivisor de un empleao
    private Empregado supervisor;
    //mapeo de los supervisados que supervisa un empleado supervisor
    private Set<Empregado> supervisados = new HashSet(0);
    //mapear familiares como colección List
    private List<Familiar> familiares = new ArrayList();
    
    //mapear componente los telefonos
    private Map<String, String> telefonos = new HashMap();
    //mapeo del departamento que pertenece un empleado
    private Departamento departamento;
    //mapeo de los empreados proyectos 
    private Set<EmpregadoProxecto> empregadoProxectos = new HashSet(0);
   //las ediciones de cursa un alumno
    private Set <Edicion> ediciones = new HashSet();
     //mapeo del vehiculo del empleado
    private Vehiculo vehiculo;

    public Empregado() {
    }
 public Empregado(String nss) {
        this.nss = nss;
    }

    public Empregado(String nss, String nome, String apelido1) {
        this.nss = nss;
        this.nome = nome;
        this.apelido1 = apelido1;
    }

    public String getNss() {
        return this.nss;
    }

    public void setNss(String nss) {
        this.nss = nss;
    }

    public Empregado getSupervisor() {
        return this.supervisor;
    }

    public Set<Empregado> getSupervisados() {
        return supervisados;
    }

    public void setSupervisados(Set<Empregado> supervisados) {
        this.supervisados = supervisados;
    }

    public void setSupervisor(Empregado supervisor) {
        this.supervisor = supervisor;
    }

    public Departamento getDepartamento() {
        return this.departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido1() {
        return this.apelido1;
    }

    public void setApelido1(String apelido1) {
        this.apelido1 = apelido1;
    }

    public String getApelido2() {
        return this.apelido2;
    }

    public void setApelido2(String apelido2) {
        this.apelido2 = apelido2;
    }

    public Date getDataNacemento() {
        return this.dataNacemento;
    }

    public void setDataNacemento(Date dataNacemento) {
        this.dataNacemento = dataNacemento;
    }

    public Character getSexo() {
        return this.sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

   
    public Map<String, String> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(Map<String, String> telefonos) {
        this.telefonos = telefonos;
    }

    public Set<EmpregadoProxecto> getEmpregadoProxectos() {
        return empregadoProxectos;
    }

    public void setEmpregadoProxectos(Set<EmpregadoProxecto> empregadoProxectos) {
        this.empregadoProxectos = empregadoProxectos;
    }

    public Set<Edicion> getEdiciones() {
        return ediciones;
    }

    public void setEdiciones(Set<Edicion> ediciones) {
        this.ediciones = ediciones;
    }

   
    public Vehiculo getVehiculo() {
        return this.vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Enderezo getEnderezo() {
        return enderezo;
    }

    public void setEnderezo(Enderezo enderezo) {
        this.enderezo = enderezo;
    }

    public List<Familiar> getFamiliares() {
        return familiares;
    }

    public void setFamiliares(List<Familiar> familiares) {
        this.familiares = familiares;
    }

    public Object getSupervisa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   @Override
public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Empregado{");
    sb.append(", nome='").append(nome).append('\'');
    sb.append(", apelido1='").append(apelido1).append('\'');
    sb.append(", apelido2='").append(apelido2).append('\'');
    sb.append(", empregadoProxectos=[");
    for (EmpregadoProxecto proxecto : empregadoProxectos) {
        sb.append(proxecto.getProxecto().getNomeProxecto()).append(", ");
    }
    if (!empregadoProxectos.isEmpty()) {
        sb.setLength(sb.length() - 2); // Eliminar la última coma y espacio
    }
    sb.append("]}");
    return sb.toString();
}

}
