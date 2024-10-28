package com.example.elecciones.Objetos;

public class Partido {
    private int id;
    private String nombrePartido;
    private String siglas;
    private String color;

    public Partido(int id, String nombrePartido, String siglas, String color) {
        this.id = id;
        this.nombrePartido = nombrePartido;
        this.siglas = siglas;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public String getNombrePartido() {
        return nombrePartido;
    }

    public String getSiglas() {
        return siglas;
    }

    public String getColor() {
        return color;
    }
}
