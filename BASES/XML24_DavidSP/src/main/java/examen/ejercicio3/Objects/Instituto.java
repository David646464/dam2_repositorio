//David sanchez Peso 77465294Y
package examen.ejercicio3.Objects;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlValue;

public class Instituto {
    private String siglas;
    private String año;
    private String sede;
    private String numProyectos;
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
    @XmlAttribute(name = "numProyectos")
    public String getNumProyectos() {
        return numProyectos;
    }

    public void setNumProyectos(String numProyectos) {
        this.numProyectos = numProyectos;
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
        stringBuilder.append("Instituto: " + lugar + "(" + siglas + ")     sede:" + sede + "     Año de creacion:" + año + "\n");
        stringBuilder.append("     Numero de proyecto: " + numProyectos + "\n");

        return stringBuilder.toString();
    }
}
