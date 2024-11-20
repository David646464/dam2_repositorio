// Especies.java
package org.example.JABX;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "Especies")
public class Especies implements Serializable {
    private List<Especie> especies;

    @XmlElement(name = "Especie")
    public List<Especie> getEspecies() {
        return especies;
    }

    public void setEspecies(List<Especie> especies) {
        this.especies = especies;
    }
}