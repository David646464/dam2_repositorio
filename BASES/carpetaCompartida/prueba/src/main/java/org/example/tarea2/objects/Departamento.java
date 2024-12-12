package org.example.tarea2.objects;

import java.sql.Date;

public class Departamento {
    private int Num_departamento;
    private String Nome_departamento;
    private String NSS_dirige;
    private Date Data_direcion;

    public Departamento(int num_departamento, String nome_departamento, String NSS_dirige, Date data_direcion) {
        Num_departamento = num_departamento;
        Nome_departamento = nome_departamento;
        this.NSS_dirige = NSS_dirige;
        Data_direcion = data_direcion;
    }

    public int getNum_departamento() {
        return Num_departamento;
    }

    public void setNum_departamento(int num_departamento) {
        Num_departamento = num_departamento;
    }

    public String getNome_departamento() {
        return Nome_departamento;
    }

    public void setNome_departamento(String nome_departamento) {
        Nome_departamento = nome_departamento;
    }

    public String getNSS_dirige() {
        return NSS_dirige;
    }

    public void setNSS_dirige(String NSS_dirige) {
        this.NSS_dirige = NSS_dirige;
    }

    public Date getData_direcion() {
        return Data_direcion;
    }

    public void setData_direcion(Date data_direcion) {
        Data_direcion = data_direcion;
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "Num_departamento=" + Num_departamento +
                ", Nome_departamento='" + Nome_departamento + '\'' +
                ", NSS_dirige='" + NSS_dirige + '\'' +
                ", Data_direcion=" + Data_direcion +
                '}';
    }
}
