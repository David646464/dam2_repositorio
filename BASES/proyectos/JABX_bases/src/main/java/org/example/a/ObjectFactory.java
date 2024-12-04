//
// Este archivo ha sido generado por Eclipse Implementation of JAXB v3.0.2 
// Visite https://eclipse-ee4j.github.io/jaxb-ri 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2024.11.14 a las 11:25:17 AM CET 
//


package org.example.a;

import jakarta.xml.bind.annotation.XmlRegistry;


@XmlRegistry
public class ObjectFactory {


    public ObjectFactory() {
    }

    public Biblioteca createBiblioteca() {
        return new Biblioteca();
    }

    public Biblioteca.Secciones createBibliotecaSecciones() {
        return new Biblioteca.Secciones();
    }

    public Biblioteca.Secciones.Seccion createBibliotecaSeccionesSeccion() {
        return new Biblioteca.Secciones.Seccion();
    }

    public Biblioteca.Secciones.Seccion.Libros createBibliotecaSeccionesSeccionLibros() {
        return new Biblioteca.Secciones.Seccion.Libros();
    }

    public Biblioteca.Secciones.Seccion.Libros.Libro createBibliotecaSeccionesSeccionLibrosLibro() {
        return new Biblioteca.Secciones.Seccion.Libros.Libro();
    }

    public Biblioteca.Secciones.Seccion.Libros.Libro.Copias createBibliotecaSeccionesSeccionLibrosLibroCopias() {
        return new Biblioteca.Secciones.Seccion.Libros.Libro.Copias();
    }

    public Biblioteca.Secciones.Seccion.Libros.Libro.Autores createBibliotecaSeccionesSeccionLibrosLibroAutores() {
        return new Biblioteca.Secciones.Seccion.Libros.Libro.Autores();
    }

    public Biblioteca.Secciones.Seccion.Libros.Libro.Copias.Copia createBibliotecaSeccionesSeccionLibrosLibroCopiasCopia() {
        return new Biblioteca.Secciones.Seccion.Libros.Libro.Copias.Copia();
    }

}
