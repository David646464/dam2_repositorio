package org.example.Tarea5.objects;

import java.sql.Date;

public class VehiculoEmpresa extends Vehiculo{
    private Date FechaCompra;
    private float Precio;

    public VehiculoEmpresa(char tipoConbustible, String modelo, String marca, String matricula, Date fechaCompra, float precio) {
        super(tipoConbustible, modelo, marca, matricula);
        FechaCompra = fechaCompra;
        Precio = precio;
    }

    public VehiculoEmpresa(int codvehiculo, String matricula, String marca, String modelo, char tipoConbustible, Date fechaCompra, float precio) {
        super(codvehiculo, matricula, marca, modelo, tipoConbustible);
        FechaCompra = fechaCompra;
        Precio = precio;
    }

    public Date getFechaCompra() {
        return FechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        FechaCompra = fechaCompra;
    }

    public float getPrecio() {
        return Precio;
    }

    public void setPrecio(float precio) {
        Precio = precio;
    }

    @Override
    public String toString() {
        return "VehiculoEmpresa{" +
                "FechaCompra=" + FechaCompra +
                ", Precio=" + Precio +
                '}';
    }
}
