//David Sánchez peso 77465294Y
package examen.Objects;

public class CasaRural extends Alojamiento{
    private char alquiler_completa;

    public CasaRural(String nombre, String direccion, String localidad, String telefono, double precio_habitacion, double cama_extra, int nomHabitaciones, char alquiler_completa) {
        super(nombre, direccion, localidad, telefono, precio_habitacion, cama_extra, nomHabitaciones);
        this.alquiler_completa = alquiler_completa;
    }

    public char getAlquiler_completa() {
        return alquiler_completa;
    }

    public void setAlquiler_completa(char alquiler_completa) {
        this.alquiler_completa = alquiler_completa;
    }

    @Override
    public String toString() {
        return "CasaRural{" +
                "alquiler_completa=" + alquiler_completa +
                '}';
    }
}
