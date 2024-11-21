//David sanchez Peso 77465294Y
package examen.ejercicio3.Objects;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlValue;

public class Universidad {
    private String siglas;
    private String año;
    private String sede;
    private String numEstudiantes;
    private String facultades;
    private String lugar;

    @XmlAttribute(name = "siglas")
    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }
    @XmlAttribute(name = "año")
    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }
    @XmlAttribute(name = "sede")
    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }
    @XmlAttribute(name = "numEstudiantes")
    public String getNumEstudiantes() {
        return numEstudiantes;
    }

    public void setNumEstudiantes(String numEstudiantes) {
        this.numEstudiantes = numEstudiantes;
    }
    @XmlAttribute(name = "facultades")
    public String getFacultades() {
        return facultades;
    }

    public void setFacultades(String facultades) {
        this.facultades = facultades;
    }
    @XmlValue
    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }
    //Metodo toString sobrescrito para lo que yo necesito
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Universdad: " + lugar + "(" + siglas + ")     sede:" + sede + "     Año de creacion:" + año + "\n");
        stringBuilder.append("     Numero de estudiantes: " + numEstudiantes +" Facultades: " + facultades +"\n");
        return stringBuilder.toString();
    }
}
