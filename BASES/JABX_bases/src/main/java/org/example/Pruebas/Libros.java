
package org.example.Pruebas;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Libros {

    @SerializedName("libro")
    private List<Libro> mLibro;

    public List<Libro> getLibro() {
        return mLibro;
    }

    public void setLibro(List<Libro> libro) {
        mLibro = libro;
    }

}
