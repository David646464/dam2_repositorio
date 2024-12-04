package org.example.Mareas;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Marea {
    private double altura;
    private String data;
    private String hora;
    private int idPorto;
    private int idTipoMarea;
    private String tipoMarea;

    // Getters and setters
    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getIdPorto() {
        return idPorto;
    }

    public void setIdPorto(int idPorto) {
        this.idPorto = idPorto;
    }

    public int getIdTipoMarea() {
        return idTipoMarea;
    }

    public void setIdTipoMarea(int idTipoMarea) {
        this.idTipoMarea = idTipoMarea;
    }

    public String getTipoMarea() {
        return tipoMarea;
    }

    public void setTipoMarea(String tipoMarea) {
        this.tipoMarea = tipoMarea;
    }

    @Override
    public String toString() {
        return "Marea{" +
                "altura=" + altura +
                ", data='" + data + '\'' +
                ", hora='" + hora + '\'' +
                ", idPorto=" + idPorto +
                ", idTipoMarea=" + idTipoMarea +
                ", tipoMarea='" + tipoMarea + '\'' +
                '}';
    }
}