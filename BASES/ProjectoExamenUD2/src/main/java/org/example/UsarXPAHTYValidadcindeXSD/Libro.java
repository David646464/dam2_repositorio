package org.example.UsarXPAHTYValidadcindeXSD;

import java.util.List;

public class Libro {
    private String ID;
    private String isbn;
    private String titulo;
    private String numeroPaginas;
    private List<String> autores;
    private String FechaPublicacion;
    private String precio;
    private List<String> copias;


    public Libro(String ID, String isbn, String titulo, String numeroPaginas, List<String> autores, String fechaPublicacion, String precio, List<String> copias) {
        this.ID = ID;
        this.isbn = isbn;
        this.titulo = titulo;
        this.numeroPaginas = numeroPaginas;
        this.autores = autores;
        FechaPublicacion = fechaPublicacion;
        this.precio = precio;
        this.copias = copias;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(String numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public List<String> getAutores() {
        return autores;
    }

    public void setAutores(List<String> autores) {
        this.autores = autores;
    }

    public String getFechaPublicacion() {
        return FechaPublicacion;
    }

    public void setFechaPublicacion(String fechaPublicacion) {
        FechaPublicacion = fechaPublicacion;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public List<String> getCopias() {
        return copias;
    }

    public void setCopias(List<String> copias) {
        this.copias = copias;
    }
}
