package org.example.PasarXmlAJson;

import jakarta.xml.bind.annotation.XmlAttribute;

public class Copia {
    private int numero;
    private String estado;

    @XmlAttribute(name = "numero")
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @XmlAttribute(name = "estado")
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}