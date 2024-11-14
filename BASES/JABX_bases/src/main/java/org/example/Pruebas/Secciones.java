
package org.example.Pruebas;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Secciones {

    @SerializedName("seccion")
    private List<Seccion> mSeccion;

    public List<Seccion> getSeccion() {
        return mSeccion;
    }

    public void setSeccion(List<Seccion> seccion) {
        mSeccion = seccion;
    }

}
