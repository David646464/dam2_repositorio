//david sanchez peso
package objetos;

import java.io.Serializable;
import java.util.List;

public class Restaurante implements Serializable {
    private int numero = 0;
    private String nombre;
    private String localidad;
    private int numCocinerosos;
    private List<InfoCocinero> cocineros;
    private boolean baja = false;

    public Restaurante( String nombre, String localidad, int numCocinerosos, List<InfoCocinero> cocineros, boolean baja) {
        this.nombre = nombre;
        this.localidad = localidad;
        this.numCocinerosos = numCocinerosos;
        this.cocineros = cocineros;
        this.baja = baja;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public int getNumComercios() {
        return numCocinerosos;
    }

    public void setNumComercios(int numComercios) {
        this.numCocinerosos = numComercios;
    }

    public List<InfoCocinero> getCocineros() {
        return cocineros;
    }

    public void setCocineros(List<InfoCocinero> cocineros) {
        this.cocineros = cocineros;
    }

    public boolean isBaja() {
        return baja;
    }

    public void setBaja(boolean baja) {
        this.baja = baja;
    }

    @Override
    public String toString() {
        return "Restaurante{" +
                "numero=" + numero +
                ", nombre='" + nombre + '\'' +
                ", localidad='" + localidad + '\'' +
                ", numComercios=" + numCocinerosos +
                ", cocineros=" + cocineros +
                ", baja=" + baja +
                '}';
    }
}
