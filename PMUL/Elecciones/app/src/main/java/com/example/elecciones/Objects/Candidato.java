package com.example.elecciones.Objects;

public class Candidato {
    private int id;
    private String nif;
    private String password;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private int edad;
    private int partido_id;
    private int votos;
    private int votosRealizados;

    public Candidato(int id, String nif, String password, String nombre, String apellido1, String apellido2, int edad, int partido_id, int votos, int votosRealizados) {
        this.id = id;
        this.nif = nif;
        this.password = password;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.edad = edad;
        this.partido_id = partido_id;
        this.votos = votos;
        this.votosRealizados = votosRealizados;
    }

    public int getId() {
        return id;
    }

    public String getNif() {
        return nif;
    }

    public String getPassword() {
        return password;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public int getEdad() {
        return edad;
    }

    public int getPartido_id() {
        return partido_id;
    }

    public int getVotos() {
        return votos;
    }

    public int getVotosRealizados() {
        return votosRealizados;
    }
}
