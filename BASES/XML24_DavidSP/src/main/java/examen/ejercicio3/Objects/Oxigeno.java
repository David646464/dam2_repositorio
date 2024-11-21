//David sanchez Peso 77465294Y
package examen.ejercicio3.Objects;

import jakarta.xml.bind.annotation.XmlValue;

public class Oxigeno {
    private String OD;

    @XmlValue
    public String getOD() {
        return OD;
    }

    public void setOD(String OD) {
        this.OD = OD;
    }
}
