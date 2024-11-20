// Pesca.java
package org.example.JABX;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "Pesca")
public class Pesca implements Serializable {
    private Especies especies;
    private List<Xornada> xornadas;

    @XmlElement(name = "Especies")
    public Especies getEspecies() {
        return especies;
    }

    public void setEspecies(Especies especies) {
        this.especies = especies;
    }

    @XmlElement(name = "Xornada")
    public List<Xornada> getXornadas() {
        return xornadas;
    }

    public void setXornadas(List<Xornada> xornadas) {
        this.xornadas = xornadas;
    }
}