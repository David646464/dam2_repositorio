package POJOS;

import java.util.*;

/**
 * */
public class Edicion implements java.io.Serializable {

    private EdicionId id;
    private Date data;
    private String lugar;
    private Curso curso;

 private Empregadofixo professor;

    public Edicion(Date fecha, String lugar, Empregadofixo empregadofixo) {
        this.data = fecha;
        this.lugar = lugar;
        this.professor = empregadofixo;
    }

    public Empregadofixo getProfessor() {
        return professor;
    }

    public void setProfessor(Empregadofixo professor) {
        this.professor = professor;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Edicion() {
    }


    public EdicionId getId() {
        return this.id;
    }

    public void setId(EdicionId id) {
        this.id = id;
    }


    public Date getData() {
        return this.data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getLugar() {
        return this.lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }


}
