//David sanchez Peso 77465294Y
package examen.ejercicio3.Objects;


import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlValue;


public class Laboratorio {
    private String siglas;
    private String año;
    private String sede;
    private String numEmpleados;
    private String especialidad;
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
    @XmlAttribute(name ="numEmpleados" )
    public String getNumEmpleados() {
        return numEmpleados;
    }

    public void setNumEmpleados(String numEmpleados) {
        this.numEmpleados = numEmpleados;
    }
    @XmlAttribute(name = "especialidad")
    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
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
        stringBuilder.append("Laboratorio: " + lugar + "(" + siglas + ")     sede:" + sede + "     Año de creacion:" + año + "\n");
        stringBuilder.append("     Empleados: " + numEmpleados +" Especialidad: " + especialidad +"\n");
        return stringBuilder.toString();
    }
}
