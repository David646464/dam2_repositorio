//David Sánchez peso 77465294Y
package examen.Objects;

public class HotelSpa extends Hotel{
    private char gorro;
    private int capacidad;

    public HotelSpa( String nombre, String direccion, String localidad, String telefono, double precio_habitacion, double cama_extra, int nomHabitaciones, int estrellas, int hotelsede, char gorro, int capacidad) {
        super(nombre, direccion, localidad, telefono, precio_habitacion, cama_extra, nomHabitaciones, estrellas, hotelsede);
        this.gorro = gorro;
        this.capacidad = capacidad;
    }

    public char getGorro() {
        return gorro;
    }

    public void setGorro(char gorro) {
        this.gorro = gorro;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return "HotelSpa{" +
                "gorro=" + gorro +
                ", capacidad=" + capacidad +
                '}';
    }
}
