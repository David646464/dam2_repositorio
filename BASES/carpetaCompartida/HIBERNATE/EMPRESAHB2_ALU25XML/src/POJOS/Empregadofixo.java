package POJOS;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedMap;


public class Empregadofixo extends Empregado implements java.io.Serializable {


    private Double salario;
    private Date dataAlta;
    private String categoria;
    private Set<Edicion> ediciones = new HashSet<>();

    public Set<Edicion> getEdiciones() {
        return ediciones;
    }

    public void setEdiciones(Set<Edicion> ediciones) {
        this.ediciones = ediciones;
    }

    public Empregadofixo() {
    }

    public Empregadofixo(String nss) {
        super(nss);
    }

    public Empregadofixo(String nss, String nome, String apelido1) {
        super(nss, nome, apelido1);
    }

    public Empregadofixo(Double salario, Date dataAlta, String categoria, String nss, String nome, String apelido1) {
        super(nss, nome, apelido1);
        this.salario = salario;
        this.dataAlta = dataAlta;
        this.categoria = categoria;
    }

    public Double getSalario() {
        return this.salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Date getDataAlta() {
        return this.dataAlta;
    }

    public void setDataAlta(Date dataAlta) {
        this.dataAlta = dataAlta;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
