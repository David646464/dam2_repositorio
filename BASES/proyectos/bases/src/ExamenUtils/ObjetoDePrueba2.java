package ExamenUtils;

import java.io.Serializable;

public class ObjetoDePrueba2 implements Serializable {
    public  String nombre;
    public  int edad;
    public boolean borrado = false;

    public ObjetoDePrueba2(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public void setBorrado(boolean borrado) {
        this.borrado = borrado;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof ObjetoDePrueba2 && ((ObjetoDePrueba2) obj).getNombre().equals(this.getNombre()) && ((ObjetoDePrueba2) obj).getEdad() == this.getEdad();
    }
}
