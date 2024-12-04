package UD1.EJ1_A3_4UD1;

import java.io.Serializable;

public class Corredor implements Serializable {
    private String nombre;
    private String apellido1;
    private String apellido2;
    private int Dorsal;
    private  double TiempoSegundos;
    private boolean borrado;

    public Corredor() {
    }

    public Corredor(String nombre, String apellido1, String apellido2, int dorsal, double tiempoSegundos, boolean borrado) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        Dorsal = dorsal;
        TiempoSegundos = tiempoSegundos;
        this.borrado = borrado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public int getDorsal() {
        return Dorsal;
    }

    public void setDorsal(int dorsal) {
        Dorsal = dorsal;
    }

    public double getTiempoSegundos() {
        return TiempoSegundos;
    }

    public void setTiempoSegundos(double tiempoSegundos) {
        TiempoSegundos = tiempoSegundos;
    }

    public boolean isBorrado() {
        return borrado;
    }

    public void setBorrado(boolean borrado) {
        this.borrado = borrado;
    }

    @Override
    public String toString() {
        return "Participante{" +
                "nombre='" + nombre + '\'' +
                ", apellido1='" + apellido1 + '\'' +
                ", apellido2= " + apellido2 + '\'' +
                ", Dorsal= " + Dorsal +
                ", TiempoSegundos= " + TiempoSegundos +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        Corredor corredor = (Corredor) obj;
        return getDorsal() == corredor.getDorsal();
    }
}
