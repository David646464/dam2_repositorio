
package org.example.Pruebas;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Biblioteca {

    @SerializedName("campus")
    private String mCampus;
    @SerializedName("facultad")
    private String mFacultad;
    @SerializedName("secciones")
    private Secciones mSecciones;

    public String getCampus() {
        return mCampus;
    }

    public void setCampus(String campus) {
        mCampus = campus;
    }

    public String getFacultad() {
        return mFacultad;
    }

    public void setFacultad(String facultad) {
        mFacultad = facultad;
    }

    public Secciones getSecciones() {
        return mSecciones;
    }

    public void setSecciones(Secciones secciones) {
        mSecciones = secciones;
    }

}
