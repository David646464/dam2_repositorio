package com.example.elecciones.Objects;

public class MiniCandidato {
    private int id;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private int votos;

    public MiniCandidato(int id, String nombre, String apellido1, String apellido2, int votos) {
        this.id = id;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.votos = votos;
    }
    public MiniCandidato(Candidato candidato) {
        this.id = candidato.getId();
        this.nombre = candidato.getNombre();
        this.apellido1 = candidato.getApellido1();
        this.apellido2 = candidato.getApellido2();
        this.votos = candidato.getVotos();
    }

    public int getId() {
        return id;
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

    public int getVotos() {
        return votos;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellido1 + " " + apellido2;
    }
}
