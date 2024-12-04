//David sanchez Peso 77465294Y
package examen.ejercicio3.Objects;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "Entidades")
public class Entidades {
    private List<Laboratorio> laboratorios;
    private List<Universidad> universidades;
    private List<Instituto> institutos;

    @XmlElement(name = "Laboratorio")
    public List<Laboratorio> getLaboratorios() {
        return laboratorios;
    }

    public void setLaboratorios(List<Laboratorio> laboratorios) {
        this.laboratorios = laboratorios;
    }
    @XmlElement(name = "Universidad")
    public List<Universidad> getUniversidades() {
        return universidades;
    }

    public void setUniversidades(List<Universidad> universidades) {
        this.universidades = universidades;
    }
    @XmlElement(name = "Instituto")
    public List<Instituto> getInstitutos() {
        return institutos;
    }

    public void setInstitutos(List<Instituto> institutos) {
        this.institutos = institutos;
    }

    //Metodo toString sobrescrito para lo que yo necesito
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Entidades:\n");
        stringBuilder.append("--------------------------------------------------------------------------------------------------------------------\n\n");
        for (Universidad universidad : universidades){
            stringBuilder.append(universidad.toString() + "\n");
        }
        for (Instituto instituto : institutos){
            stringBuilder.append(instituto.toString()+ "\n");
        }
        for (Laboratorio laboratorio : laboratorios){
            stringBuilder.append(laboratorio.toString()+ "\n");
        }
        return stringBuilder.toString();
    }
}
