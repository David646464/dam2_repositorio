package org.example.PasarXmlAJson;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "autores")
public class Autores {
    private List<String> autor;

    @XmlElement(name = "autor")
    public List<String> getAutor() {
        return autor;
    }

    public void setAutor(List<String> autor) {
        this.autor = autor;
    }
}