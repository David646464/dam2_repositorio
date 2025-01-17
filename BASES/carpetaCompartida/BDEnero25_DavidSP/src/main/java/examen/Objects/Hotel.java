//David Sánchez peso 77465294Y
package examen.Objects;

public class Hotel extends Alojamiento{
    private int estrellas;
    private int hotelsede;

    public Hotel( String nombre, String direccion, String localidad, String telefono, double precio_habitacion, double cama_extra, int nomHabitaciones, int estrellas, int hotelsede) {
        super( nombre, direccion, localidad, telefono, precio_habitacion, cama_extra, nomHabitaciones);
        this.estrellas = estrellas;
        this.hotelsede = hotelsede;
    }

    public int getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(int estrellas) {
        this.estrellas = estrellas;
    }

    public int getHotelsede() {
        return hotelsede;
    }

    public void setHotelsede(int hotelsede) {
        this.hotelsede = hotelsede;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "estrellas=" + estrellas +
                ", hotelsede=" + hotelsede +
                '}';
    }
}
