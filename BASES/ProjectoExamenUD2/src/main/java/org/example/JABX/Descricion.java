// Descricion.java
package org.example.JABX;

import jakarta.xml.bind.annotation.XmlValue;

import java.io.Serializable;

public class Descricion implements Serializable {
    private String texto;

    @XmlValue
    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}