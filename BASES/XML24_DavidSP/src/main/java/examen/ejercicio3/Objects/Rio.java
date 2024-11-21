//David sanchez Peso 77465294Y
package examen.ejercicio3.Objects;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;

import java.util.List;

public class Rio {
    private String codigo;
    private String nombre;
    private List<Medicion> mediciones;
    private double mediaOxigeno = 0;
    private double mediatemperatura = 0;

    @XmlAttribute(name = "codigo")
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    @XmlAttribute(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @XmlElement(name = "Medicion")
    public List<Medicion> getMediciones() {
        return mediciones;
    }

    public void setMediciones(List<Medicion> mediciones) {
        this.mediciones = mediciones;
    }

    public double getMediaOxigeno() {
        return mediaOxigeno;
    }

    public double getMediatemperatura() {
        return mediatemperatura;
    }
    //Metodo toString sobrescrito para lo que yo necesito
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Rio:" + nombre + "(" + codigo + ")\n");
        for (Medicion medicion : mediciones){
            stringBuilder.append("     " + medicion.toString() + "\n");
        }
        mediaOxigeno = conseguirMediaOxigeno();
        mediatemperatura = conseguirMediatemperatura();
        stringBuilder.append("--------------------------------------------------------------------------------------------------------------------\n");
        stringBuilder.append("                                     Media del oxigeno disuelto:" + String.valueOf(mediaOxigeno) + " mg/l  Media de la temperatura: " + mediatemperatura + "º\n");
        stringBuilder.append("--------------------------------------------------------------------------------------------------------------------\n");

        return stringBuilder.toString();
    }

    //Metodo para conseguir la media de temperatura
    private double conseguirMediatemperatura() {
        double resultado =0;
        for (Medicion medicion : mediciones){
            resultado += Double.parseDouble(medicion.getTemperatura().getGrados());
        }
        if (mediciones.size() > 0){
            resultado = resultado / mediciones.size();
        }
        if (String.valueOf(resultado).contains(".")){
            String x = String.valueOf(resultado);
            resultado = Double.valueOf(x.substring(0, x.indexOf(".")+2));
        }
        return resultado;
    }
    //Metodo para conseguir la media de oxigeno
    private double conseguirMediaOxigeno() {
        double resultado =0;
        for (Medicion medicion : mediciones){
            resultado += Double.parseDouble(medicion.getOxigeno().getOD());
        }
        if (mediciones.size() > 0){
            resultado = resultado / mediciones.size();
        }
        if (String.valueOf(resultado).contains(".")){
            String x = String.valueOf(resultado);
            resultado = Double.valueOf(x.substring(0, x.indexOf(".")+2));
        }
        return resultado;
    }
}
