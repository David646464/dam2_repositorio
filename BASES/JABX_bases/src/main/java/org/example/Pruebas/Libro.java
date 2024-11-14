
package org.example.Pruebas;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Libro {

    @SerializedName("autores")
    private Autores mAutores;
    @SerializedName("copias")
    private Copias mCopias;
    @SerializedName("editorial")
    private String mEditorial;
    @SerializedName("fechaEdicion")
    private String mFechaEdicion;
    @SerializedName("id")
    private String mId;
    @SerializedName("isbn")
    private String mIsbn;
    @SerializedName("numeroDePaginas")
    private Long mNumeroDePaginas;
    @SerializedName("precio")
    private Double mPrecio;
    @SerializedName("titulo")
    private String mTitulo;

    public Autores getAutores() {
        return mAutores;
    }

    public void setAutores(Autores autores) {
        mAutores = autores;
    }

    public Copias getCopias() {
        return mCopias;
    }

    public void setCopias(Copias copias) {
        mCopias = copias;
    }

    public String getEditorial() {
        return mEditorial;
    }

    public void setEditorial(String editorial) {
        mEditorial = editorial;
    }

    public String getFechaEdicion() {
        return mFechaEdicion;
    }

    public void setFechaEdicion(String fechaEdicion) {
        mFechaEdicion = fechaEdicion;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getIsbn() {
        return mIsbn;
    }

    public void setIsbn(String isbn) {
        mIsbn = isbn;
    }

    public Long getNumeroDePaginas() {
        return mNumeroDePaginas;
    }

    public void setNumeroDePaginas(Long numeroDePaginas) {
        mNumeroDePaginas = numeroDePaginas;
    }

    public Double getPrecio() {
        return mPrecio;
    }

    public void setPrecio(Double precio) {
        mPrecio = precio;
    }

    public String getTitulo() {
        return mTitulo;
    }

    public void setTitulo(String titulo) {
        mTitulo = titulo;
    }

}
