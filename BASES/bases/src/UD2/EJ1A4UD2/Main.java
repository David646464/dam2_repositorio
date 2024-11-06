package UD2.EJ1A4UD2;

import UD2.util.UtilXmlManager;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        //a) A partir del anterior documento, crea un árbol DOM con validación por esquema. El ID del libro es un
        //atributo xs:ID , el nombre de la sección y el ISBN son únicos.
        ManejadorBiblioteca manejadorBiblioteca = new ManejadorBiblioteca("src/UD2/EJ1A4UD2/BibliotecaInformatica.xml", "src/UD2/EJ1A4UD2/BibliotecaInformatica.xsd");
        //b)Crea un metodo que se le pase una sección y devuelva una lista de los libros que están en dicha
        //sección. Si no existe dar un mensaje al respecto. Crea un método para visualizar los libros.
        //manejadorBiblioteca.librosPorSeccion("Programación");
        //c) Crea un metodo que visualice de forma ordenada de mayor a menor, el número de libros que hay por
        //cada sección. Para los que coincidan en el número de libros, de menor a mayor por el nombre
        //sección,
        //En este metodo habrá una llamada a un método que se le pase el nombre de la sección y devuelva el
        //número de libros de dicha sección.
        //manejadorBiblioteca.secionesOrdenadasPorNumLibros();
        //d)Hacer un metodo que reciba un ISBN de un libro, un numero de copia y un estado y permita modificar
        //el estado de la copia.
        //manejadorBiblioteca.modificarEstadoCopia("666-1234567890", 1, "Disponible");
        //e) Haz un metodo que reciba la información completa de un libro y una sección y añada este libro a la
        //sección. Si la sección no existe se crea y se añade el libro
        Libro libro = new Libro("A007", "1234567890", "Libro de prueba", 100, List.of("Autor1", "Autor2"), LocalDate.of(2023, 10, 5), "Editorial", 10.0, List.of(new Copia(1, "Disponible")));
        manejadorBiblioteca.anadirLibroASeccion(libro, "Programación");

    }
}
