//David sanchez Peso 77465294Y
package examen.ejercicio3.Objects;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Programa")
public class Programa {
    private String denominacion;
    private String pais;
    private Entidades entidades;
    private Rios rios;

    @XmlAttribute(name = "denominacion")
    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }
    @XmlAttribute(name = "pais")
    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    @XmlElement(name = "Entidades" )
    public Entidades getEntidades() {
        return entidades;
    }

    public void setEntidades(Entidades entidades) {
        this.entidades = entidades;
    }
    @XmlElement(name = "Rios" )
    public Rios getRios() {
        return rios;
    }

    public void setRios(Rios rios) {
        this.rios = rios;
    }

    public void imprimirInformacion() {
        System.out.println(this.toString());
    }
    //Metodo toString sobrescrito para lo que yo necesito
    @Override
    public String toString() {

        return "Programa:" + denominacion + "    Pais:" + pais + "\n\n" + entidades.toString() + "\n" + rios.toString();
    }
}
