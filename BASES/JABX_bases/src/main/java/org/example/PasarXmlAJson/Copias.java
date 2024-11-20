package org.example.PasarXmlAJson;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "copias")
public class Copias {
    private List<Copia> copia;

    @XmlElement(name = "copia")
    public List<Copia> getCopia() {
        return copia;
    }

    public void setCopia(List<Copia> copia) {
        this.copia = copia;
    }
}