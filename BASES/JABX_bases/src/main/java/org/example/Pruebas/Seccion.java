
package org.example.Pruebas;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Seccion {

    @SerializedName("libros")
    private Libros mLibros;
    @SerializedName("nombre")
    private String mNombre;

    public Libros getLibros() {
        return mLibros;
    }

    public void setLibros(Libros libros) {
        mLibros = libros;
    }

    public String getNombre() {
        return mNombre;
    }

    public void setNombre(String nombre) {
        mNombre = nombre;
    }

}
