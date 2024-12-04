package org.example.a;

import org.example.a.Biblioteca;
import org.example.a.ObjectFactory;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        ObjectFactory factory = new ObjectFactory();

        // Create Biblioteca instance
        Biblioteca biblioteca = factory.createBiblioteca();
        biblioteca.setFacultad("Facultad de Ingeniería");
        biblioteca.setCampus("Campus Central");

        // Create Secciones instance
        Biblioteca.Secciones secciones = factory.createBibliotecaSecciones();
        biblioteca.setSecciones(secciones);

        // Create Seccion instance
        Biblioteca.Secciones.Seccion seccion = factory.createBibliotecaSeccionesSeccion();
        seccion.setNombre("Informática");
        secciones.getSeccion().add(seccion);

        // Create Libros instance
        Biblioteca.Secciones.Seccion.Libros libros = factory.createBibliotecaSeccionesSeccionLibros();
        seccion.setLibros(libros);

        // Create Libro instance
        Biblioteca.Secciones.Seccion.Libros.Libro libro = factory.createBibliotecaSeccionesSeccionLibrosLibro();
        libro.setID("A1001");
        libro.setIsbn("978-1234567890");
        libro.setTitulo("Programación en Java");
        libro.setNumeroDePaginas(BigInteger.valueOf(500));
        libro.setFechaEdicion("01-01-2020");
        libro.setEditorial("Editorial ABC");
        libro.setPrecio(BigDecimal.valueOf(49.99));
        libros.getLibro().add(libro);

        // Create Autores instance
        Biblioteca.Secciones.Seccion.Libros.Libro.Autores autores = factory.createBibliotecaSeccionesSeccionLibrosLibroAutores();
        autores.getAutor().add("John Doe");
        autores.getAutor().add("Jane Smith");
        libro.setAutores(autores);

        // Create Copias instance
        Biblioteca.Secciones.Seccion.Libros.Libro.Copias copias = factory.createBibliotecaSeccionesSeccionLibrosLibroCopias();
        libro.setCopias(copias);

        // Create Copia instances
        Biblioteca.Secciones.Seccion.Libros.Libro.Copias.Copia copia1 = factory.createBibliotecaSeccionesSeccionLibrosLibroCopiasCopia();
        copia1.setNumero("1");
        copia1.setEstado("Disponible");
        copias.getCopia().add(copia1);

        Biblioteca.Secciones.Seccion.Libros.Libro.Copias.Copia copia2 = factory.createBibliotecaSeccionesSeccionLibrosLibroCopiasCopia();
        copia2.setNumero("2");
        copia2.setEstado("Prestado");
        copias.getCopia().add(copia2);

        // Print the Biblioteca object to verify the data
        System.out.println("Facultad: " + biblioteca.getFacultad());
        System.out.println("Campus: " + biblioteca.getCampus());
        for (Biblioteca.Secciones.Seccion sec : biblioteca.getSecciones().getSeccion()) {
            System.out.println("Sección: " + sec.getNombre());
            for (Biblioteca.Secciones.Seccion.Libros.Libro lib : sec.getLibros().getLibro()) {
                System.out.println("Libro ID: " + lib.getID());
                System.out.println("Título: " + lib.getTitulo());
                System.out.println("ISBN: " + lib.getIsbn());
                System.out.println("Número de páginas: " + lib.getNumeroDePaginas());
                System.out.println("Fecha de edición: " + lib.getFechaEdicion());
                System.out.println("Editorial: " + lib.getEditorial());
                System.out.println("Precio: " + lib.getPrecio());
                System.out.println("Autores: " + String.join(", ", lib.getAutores().getAutor()));
                for (Biblioteca.Secciones.Seccion.Libros.Libro.Copias.Copia cop : lib.getCopias().getCopia()) {
                    System.out.println("Copia número: " + cop.getNumero() + ", Estado: " + cop.getEstado());
                }
            }
        }
    }
}