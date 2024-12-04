package UD2.EL1A6UD2;

public class Empleado {
    private String nombreCompleto;
    private String dni;
    private Integer edad;

    public Empleado(String nombreCompleto, String dni, Integer edad) {
        this.nombreCompleto = nombreCompleto;
        this.dni = dni;
        this.edad = edad;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getDni() {
        return dni;
    }
    public Integer getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombreCompleto='" + nombreCompleto + '\'' +
                ", dni='" + dni + '\'' +
                ", edad=" + edad +
                '}';
    }


}
