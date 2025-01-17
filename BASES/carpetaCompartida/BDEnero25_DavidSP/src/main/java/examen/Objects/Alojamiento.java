//David Sánchez peso 77465294Y
package examen.Objects;

public class Alojamiento {
    private int codigo;
    private String nombre;
    private String direccion;
    private String localidad;
    private String telefono;
    private double precio_habitacion;
    private double cama_extra;
    private int nomHabitaciones;

    public Alojamiento( String nombre, String direccion, String localidad, String telefono, double precio_habitacion, double cama_extra, int nomHabitaciones) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.localidad = localidad;
        this.telefono = telefono;
        this.precio_habitacion = precio_habitacion;
        this.cama_extra = cama_extra;
        this.nomHabitaciones = nomHabitaciones;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public double getPrecio_habitacion() {
        return precio_habitacion;
    }

    public void setPrecio_habitacion(double precio_habitacion) {
        this.precio_habitacion = precio_habitacion;
    }

    public double getCama_extra() {
        return cama_extra;
    }

    public void setCama_extra(double cama_extra) {
        this.cama_extra = cama_extra;
    }

    public int getNomHabitaciones() {
        return nomHabitaciones;
    }

    public void setNomHabitaciones(int nomHabitaciones) {
        this.nomHabitaciones = nomHabitaciones;
    }

    @Override
    public String toString() {
        return "Alojamiento{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", localidad='" + localidad + '\'' +
                ", telefono='" + telefono + '\'' +
                ", precio_habitacion=" + precio_habitacion +
                ", cama_extra=" + cama_extra +
                ", nomHabitaciones='" + nomHabitaciones + '\'' +
                '}';
    }
}
