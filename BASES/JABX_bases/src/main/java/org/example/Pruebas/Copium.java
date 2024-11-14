
package org.example.Pruebas;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Copium {

    @SerializedName("estado")
    private String mEstado;
    @SerializedName("numero")
    private Long mNumero;

    public String getEstado() {
        return mEstado;
    }

    public void setEstado(String estado) {
        mEstado = estado;
    }

    public Long getNumero() {
        return mNumero;
    }

    public void setNumero(Long numero) {
        mNumero = numero;
    }

}
