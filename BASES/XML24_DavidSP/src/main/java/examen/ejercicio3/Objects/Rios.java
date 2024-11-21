//David sanchez Peso 77465294Y
package examen.ejercicio3.Objects;


import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;


import java.util.List;

@XmlRootElement(name = "Rios")
public class Rios {
    private List<Rio> rios;
    private double mediaOxigenoTotal;
    private double mediaTemperaturaTotal;

   @XmlElement(name = "Rio")
    public List<Rio> getRios() {
        return rios;
    }

    public void setRios(List<Rio> rios) {
        this.rios = rios;
    }
    //Metodo toString sobrescrito para lo que yo necesito
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Rios:\n");
        stringBuilder.append("--------------------------------------------------------------------------------------------------------------------\n\n");
        for (Rio rio: rios){
            stringBuilder.append(rio.toString()+"\n");
        }
        mediaOxigenoTotal = getMediaOxigenoDisueltoTotal();
        mediaTemperaturaTotal = getMediaTemperaturaTotal();
        stringBuilder.append("                                     Media del oxigeno disuelto total: " + String.valueOf(mediaOxigenoTotal) + " mg/l Media de la Temperatura: " + String.valueOf(mediaTemperaturaTotal) + " º\n");
        return  stringBuilder.toString();
    }
    //Conseguir la media d temperatura de un rio
    private double getMediaTemperaturaTotal() {
       double resultado = 0;

       for (Rio rio : rios){
           resultado+= rio.getMediatemperatura();
       }
       if (!rios.isEmpty()){
           resultado = resultado / rios.size();
       }
        if (String.valueOf(resultado).contains(".")){
            String x = String.valueOf(resultado);
            resultado = Double.valueOf(x.substring(0, x.indexOf(".")+3));
        }
       return resultado;
    }
    //Conseguir la media d oxigeno de un rio
    private double getMediaOxigenoDisueltoTotal() {
        double resultado = 0;

        for (Rio rio : rios){
            resultado+= rio.getMediaOxigeno();
        }
        if (!rios.isEmpty()){
            resultado = resultado / rios.size();
        }
        if (String.valueOf(resultado).contains(".")){
            String x = String.valueOf(resultado);
           resultado = Double.valueOf(x.substring(0, x.indexOf(".")+3));
        }
        return resultado;
    }
}
