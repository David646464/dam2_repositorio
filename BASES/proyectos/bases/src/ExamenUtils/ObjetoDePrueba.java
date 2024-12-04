package ExamenUtils;

import java.io.Serializable;

public class ObjetoDePrueba implements Serializable {
    public  String nombre;

    public ObjetoDePrueba(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof ObjetoDePrueba && ((ObjetoDePrueba) obj).getNombre().equals(this.getNombre());
    }
}
