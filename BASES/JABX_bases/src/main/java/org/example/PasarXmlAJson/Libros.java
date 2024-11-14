package org.example.PasarXmlAJson;

import jakarta.xml.bind.annotation.XmlElement;
import java.util.List;

public class Libros {
    private List<Libro> libro;

    @XmlElement(name = "libro")
    public List<Libro> getLibro() {
        return libro;
    }

    public void setLibro(List<Libro> libro) {
        this.libro = libro;
    }
}