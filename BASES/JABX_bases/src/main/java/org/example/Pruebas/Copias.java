
package org.example.Pruebas;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Copias {

    @SerializedName("copia")
    private List<Copium> mCopia;

    public List<Copium> getCopia() {
        return mCopia;
    }

    public void setCopia(List<Copium> copia) {
        mCopia = copia;
    }

}
