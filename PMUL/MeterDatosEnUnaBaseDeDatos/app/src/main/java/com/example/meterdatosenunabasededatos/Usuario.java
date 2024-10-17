package com.example.meterdatosenunabasededatos;

import java.io.Serializable;

public class Usuario implements Serializable {
    private int id;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private int edad;
    private boolean vip;
    private int provincia_id;

    public Usuario(int id, String nombre, String apellido1, String apellido2, int edad, boolean vip, int provincia_id) {
        this.id = id;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.edad = edad;
        this.vip = vip;
        this.provincia_id = provincia_id;
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

    public int getEdad() {
        return edad;
    }

    public boolean isVip() {
        return vip;
    }

    public int getProvincia_id() {
        return provincia_id;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido1='" + apellido1 + '\'' +
                ", apellido2='" + apellido2 + '\'' +
                ", edad=" + edad +
                ", vip=" + vip +
                ", provincia_id=" + provincia_id +
                '}';
    }
}
