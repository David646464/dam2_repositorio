//
// Este archivo ha sido generado por Eclipse Implementation of JAXB v3.0.2 
// Visite https://eclipse-ee4j.github.io/jaxb-ri 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2024.11.20 a las 12:36:53 PM CET 
//


package org.example.b;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlID;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "facultad",
    "campus",
    "secciones"
})
@XmlRootElement(name = "biblioteca")
public class Biblioteca {

    @XmlElement(required = true)
    protected String facultad;
    @XmlElement(name = "Campus", required = true)
    protected String campus;
    @XmlElement(required = true)
    protected Biblioteca.Secciones secciones;

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String value) {
        this.facultad = value;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String value) {
        this.campus = value;
    }

    public Biblioteca.Secciones getSecciones() {
        return secciones;
    }

    public void setSecciones(Biblioteca.Secciones value) {
        this.secciones = value;
    }


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "seccion"
    })
    public static class Secciones {

        @XmlElement(required = true)
        protected List<Biblioteca.Secciones.Seccion> seccion;

        public List<Biblioteca.Secciones.Seccion> getSeccion() {
            if (seccion == null) {
                seccion = new ArrayList<Biblioteca.Secciones.Seccion>();
            }
            return this.seccion;
        }


        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "libros"
        })
        public static class Seccion {

            @XmlElement(required = true)
            protected Biblioteca.Secciones.Seccion.Libros libros;
            @XmlAttribute(name = "nombre", required = true)
            protected String nombre;

            public Biblioteca.Secciones.Seccion.Libros getLibros() {
                return libros;
            }

            public void setLibros(Biblioteca.Secciones.Seccion.Libros value) {
                this.libros = value;
            }

            public String getNombre() {
                return nombre;
            }

            public void setNombre(String value) {
                this.nombre = value;
            }


            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "libro"
            })
            public static class Libros {

                @XmlElement(required = true)
                protected List<Biblioteca.Secciones.Seccion.Libros.Libro> libro;

                public List<Biblioteca.Secciones.Seccion.Libros.Libro> getLibro() {
                    if (libro == null) {
                        libro = new ArrayList<Biblioteca.Secciones.Seccion.Libros.Libro>();
                    }
                    return this.libro;
                }


                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                    "autores",
                    "fechaEdicion",
                    "editorial",
                    "precio",
                    "copias"
                })
                public static class Libro {

                    @XmlElement(required = true)
                    protected Biblioteca.Secciones.Seccion.Libros.Libro.Autores autores;
                    @XmlElement(required = true)
                    protected String fechaEdicion;
                    @XmlElement(required = true)
                    protected String editorial;
                    @XmlElement(required = true)
                    protected BigDecimal precio;
                    @XmlElement(required = true)
                    protected Biblioteca.Secciones.Seccion.Libros.Libro.Copias copias;
                    @XmlAttribute(name = "ID", required = true)
                    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
                    @XmlID
                    @XmlSchemaType(name = "ID")
                    protected String id;
                    @XmlAttribute(name = "isbn", required = true)
                    protected String isbn;
                    @XmlAttribute(name = "titulo", required = true)
                    protected String titulo;
                    @XmlAttribute(name = "numero_de_paginas", required = true)
                    protected BigInteger numeroDePaginas;

                    public Biblioteca.Secciones.Seccion.Libros.Libro.Autores getAutores() {
                        return autores;
                    }

                    public void setAutores(Biblioteca.Secciones.Seccion.Libros.Libro.Autores value) {
                        this.autores = value;
                    }

                    public String getFechaEdicion() {
                        return fechaEdicion;
                    }

                    public void setFechaEdicion(String value) {
                        this.fechaEdicion = value;
                    }

                    public String getEditorial() {
                        return editorial;
                    }

                    public void setEditorial(String value) {
                        this.editorial = value;
                    }

                    public BigDecimal getPrecio() {
                        return precio;
                    }

                    public void setPrecio(BigDecimal value) {
                        this.precio = value;
                    }

                    public Biblioteca.Secciones.Seccion.Libros.Libro.Copias getCopias() {
                        return copias;
                    }

                    public void setCopias(Biblioteca.Secciones.Seccion.Libros.Libro.Copias value) {
                        this.copias = value;
                    }

                    public String getID() {
                        return id;
                    }

                    public void setID(String value) {
                        this.id = value;
                    }

                    public String getIsbn() {
                        return isbn;
                    }

                    public void setIsbn(String value) {
                        this.isbn = value;
                    }

                    public String getTitulo() {
                        return titulo;
                    }

                    public void setTitulo(String value) {
                        this.titulo = value;
                    }

                    public BigInteger getNumeroDePaginas() {
                        return numeroDePaginas;
                    }

                    public void setNumeroDePaginas(BigInteger value) {
                        this.numeroDePaginas = value;
                    }


                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(name = "", propOrder = {
                        "autor"
                    })
                    public static class Autores {

                        @XmlElement(required = true)
                        protected List<String> autor;

                        public List<String> getAutor() {
                            if (autor == null) {
                                autor = new ArrayList<String>();
                            }
                            return this.autor;
                        }

                    }


                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(name = "", propOrder = {
                        "copia"
                    })
                    public static class Copias {

                        @XmlElement(required = true)
                        protected List<Biblioteca.Secciones.Seccion.Libros.Libro.Copias.Copia> copia;

                        public List<Biblioteca.Secciones.Seccion.Libros.Libro.Copias.Copia> getCopia() {
                            if (copia == null) {
                                copia = new ArrayList<Biblioteca.Secciones.Seccion.Libros.Libro.Copias.Copia>();
                            }
                            return this.copia;
                        }


                        @XmlAccessorType(XmlAccessType.FIELD)
                        @XmlType(name = "")
                        public static class Copia {

                            @XmlAttribute(name = "numero")
                            protected String numero;
                            @XmlAttribute(name = "estado")
                            protected String estado;

                            public String getNumero() {
                                return numero;
                            }

                            public void setNumero(String value) {
                                this.numero = value;
                            }

                            public String getEstado() {
                                return estado;
                            }

                            public void setEstado(String value) {
                                this.estado = value;
                            }

                        }

                    }

                }

            }

        }

    }

}
