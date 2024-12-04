package org.example.PasarXmlAJson;

import jakarta.xml.bind.annotation.XmlElement;
import java.util.List;

public class Secciones {
    private List<Seccion> seccion;

    @XmlElement(name = "seccion")
    public List<Seccion> getSeccion() {
        return seccion;
    }

    public void setSeccion(List<Seccion> seccion) {
        this.seccion = seccion;
    }
}