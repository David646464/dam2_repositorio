package com.example.elecciones.Objects;

public class Usuario {
    private int id;
    private String nif;
    private String password;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private int edad;
    private int votosRealizados;

    public Usuario(int id, String nif, String password, String nombre, String apellido1, String apellido2, int edad, int votosRealizados) {
        this.id = id;
        this.nif = nif;
        this.password = password;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.edad = edad;
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

    public int getVotosRealizados() {
        return votosRealizados;
    }
}
