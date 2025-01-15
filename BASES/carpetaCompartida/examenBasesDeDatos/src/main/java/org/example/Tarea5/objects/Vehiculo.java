package org.example.Tarea5.objects;

public class Vehiculo {
    private int codvehiculo ;
    private String matricula;
    private String marca;
    private String modelo;
    private char TipoConbustible = 'D';

    public Vehiculo(char tipoConbustible, String modelo, String marca, String matricula) {
        TipoConbustible = tipoConbustible;
        this.modelo = modelo;
        this.marca = marca;
        this.matricula = matricula;
    }

    public Vehiculo(int codvehiculo, String matricula, String marca, String modelo, char tipoConbustible) {
        this.codvehiculo = codvehiculo;
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        TipoConbustible = tipoConbustible;
    }

    public int getCodvehiculo() {
        return codvehiculo;
    }

    public void setCodvehiculo(int codvehiculo) {
        this.codvehiculo = codvehiculo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public char getTipoConbustible() {
        return TipoConbustible;
    }

    public void setTipoConbustible(char tipoConbustible) {
        TipoConbustible = tipoConbustible;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "codvehiculo=" + codvehiculo +
                ", matricula='" + matricula + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", TipoConbustible=" + TipoConbustible +
                '}';
    }
}
