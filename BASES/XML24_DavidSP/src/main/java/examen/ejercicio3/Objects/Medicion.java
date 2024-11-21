//David sanchez Peso 77465294Y
package examen.ejercicio3.Objects;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;

public class Medicion {
    private String fecha;
    private String calidad;
    private pH pH;
    private Oxigeno oxigeno;
    private Temperatura temperatura;

    @XmlAttribute(name = "fecha")
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    @XmlAttribute(name = "calidad")
    public String getCalidad() {
        return calidad;
    }

    public void setCalidad(String calidad) {
        this.calidad = calidad;
    }
    @XmlElement(name = "pH")
    public examen.ejercicio3.Objects.pH getpH() {
        return pH;
    }

    public void setpH(examen.ejercicio3.Objects.pH pH) {
        this.pH = pH;
    }
    @XmlElement(name = "Oxigeno")
    public Oxigeno getOxigeno() {
        return oxigeno;
    }

    public void setOxigeno(Oxigeno oxigeno) {
        this.oxigeno = oxigeno;
    }
    @XmlElement(name = "Temperatura")
    public Temperatura getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Temperatura temperatura) {
        this.temperatura = temperatura;
    }

    //Metodo toString sobrescrito para lo que yo necesito
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fecha:" + fecha + "     calidad: " + calidad + "     Ph: " + pH.getPh() + "(" + pH.getTipo() + ")     Oxigeno:" + oxigeno.getOD() + " mg/l Temperatura: " + temperatura.getGrados() + "º"  );
        return stringBuilder.toString();
    }
}
