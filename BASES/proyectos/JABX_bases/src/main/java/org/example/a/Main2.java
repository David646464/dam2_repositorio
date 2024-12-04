package org.example.a;


import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;

public class Main2 {
    public static void main(String[] args) {
        try {
            // Create JAXB context and unmarshaller
            JAXBContext context = JAXBContext.newInstance(Biblioteca.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            // Unmarshal XML file to Biblioteca object
            File xmlFile = new File("src/main/java/org/example/Documentos/BibliotecaInformatica.xml");
            Biblioteca biblioteca = (Biblioteca) unmarshaller.unmarshal(xmlFile);

            // Print book details
            for (Biblioteca.Secciones.Seccion seccion : biblioteca.getSecciones().getSeccion()) {
                for (Biblioteca.Secciones.Seccion.Libros.Libro libro : seccion.getLibros().getLibro()) {
                    System.out.println("Libro ID: " + libro.getID());
                    System.out.println("Título: " + libro.getTitulo());
                    System.out.println("ISBN: " + libro.getIsbn());
                    System.out.println("Número de páginas: " + libro.getNumeroDePaginas());
                    System.out.println("Fecha de edición: " + libro.getFechaEdicion());
                    System.out.println("Editorial: " + libro.getEditorial());
                    System.out.println("Precio: " + libro.getPrecio());
                    System.out.println("Autores: " + String.join(", ", libro.getAutores().getAutor()));
                    System.out.println();
                }
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}