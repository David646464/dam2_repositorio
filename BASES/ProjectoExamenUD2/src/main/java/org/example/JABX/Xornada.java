// Xornada.java
package org.example.JABX;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;

import java.io.Serializable;
import java.util.List;

public class Xornada implements Serializable {
    private String lugar;
    private String data;
    private List<Captura> capturas;
    private String descricion;

    @XmlAttribute
    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    @XmlAttribute
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @XmlElement(name = "Captura")
    public List<Captura> getCapturas() {
        return capturas;
    }

    public void setCapturas(List<Captura> capturas) {
        this.capturas = capturas;
    }

    @XmlElement(name = "Descricion")
    public String getDescricion() {
        return descricion;
    }

    public void setDescricion(String descricion) {
        this.descricion = descricion;
    }
}