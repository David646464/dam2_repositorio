package org.example.Tarea5.objects;

import java.sql.Date;

public class VehiculoRenting extends Vehiculo{
    private Date FechaInicio;
    private float PrecioMensual = 0;
    private int numMeses = 0;

    public VehiculoRenting(char tipoConbustible, String modelo, String marca, String matricula, Date fechaInicio, float precioMensual, int numMeses) {
        super(tipoConbustible, modelo, marca, matricula);
        FechaInicio = fechaInicio;
        PrecioMensual = precioMensual;
        this.numMeses = numMeses;
    }

    public VehiculoRenting(int codvehiculo, String matricula, String marca, String modelo, char tipoConbustible, Date fechaInicio, float precioMensual, int numMeses) {
        super(codvehiculo, matricula, marca, modelo, tipoConbustible);
        FechaInicio = fechaInicio;
        PrecioMensual = precioMensual;
        this.numMeses = numMeses;
    }

    public Date getFechaInicio() {
        return FechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        FechaInicio = fechaInicio;
    }

    public float getPrecioMensual() {
        return PrecioMensual;
    }

    public void setPrecioMensual(float precioMensual) {
        PrecioMensual = precioMensual;
    }

    public int getNumMeses() {
        return numMeses;
    }

    public void setNumMeses(int numMeses) {
        this.numMeses = numMeses;
    }
}
