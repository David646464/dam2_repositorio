package org.example.Mareas;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Mareas {
    private String data;
    private int idPorto;
    private int idPortoRef;
    private double latitude;
    private List<Marea> listaMareas;
    private double lonxitude;
    private String nomePorto;

    // Getters and setters
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getIdPorto() {
        return idPorto;
    }

    public void setIdPorto(int idPorto) {
        this.idPorto = idPorto;
    }

    public int getIdPortoRef() {
        return idPortoRef;
    }

    public void setIdPortoRef(int idPortoRef) {
        this.idPortoRef = idPortoRef;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public List<Marea> getListaMareas() {
        return listaMareas;
    }

    public void setListaMareas(List<Marea> listaMareas) {
        this.listaMareas = listaMareas;
    }

    public double getLonxitude() {
        return lonxitude;
    }

    public void setLonxitude(double lonxitude) {
        this.lonxitude = lonxitude;
    }

    public String getNomePorto() {
        return nomePorto;
    }

    public void setNomePorto(String nomePorto) {
        this.nomePorto = nomePorto;
    }

    @Override
    public String toString() {
        return "Mareas{" +
                "data='" + data + '\'' +
                ", idPorto=" + idPorto +
                ", idPortoRef=" + idPortoRef +
                ", latitude=" + latitude +
                ", listaMareas=" + listaMareas +
                ", lonxitude=" + lonxitude +
                ", nomePorto='" + nomePorto + '\'' +
                '}';
    }


}