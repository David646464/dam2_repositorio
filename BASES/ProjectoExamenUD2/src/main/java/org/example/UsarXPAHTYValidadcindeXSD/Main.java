package org.example.UsarXPAHTYValidadcindeXSD;



import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            // Crear una instancia de DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);

            // Crear un DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parsear el archivo XML
            Document document = builder.parse(new File("src/main/resources/BibliotecaInformatica.xml"));

            // Crear un SchemaFactory para el esquema XSD
            SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");

            // Cargar el esquema XSD
            Schema schema = schemaFactory.newSchema(new File("src/main/resources/BibliotecaInformatica.xsd"));

            // Crear un validador a partir del esquema
            Validator validator = schema.newValidator();

            // Validar el documento XML contra el esquema
            validator.validate(new DOMSource(document));

            System.out.println("El documento XML es válido.");

            //Buscar con XPAH todos los libros que esten en una seccion
            AccionesDOM accionesDOM = new AccionesDOM("src/main/resources/BibliotecaInformatica.xml");
            List<Libro> libros = accionesDOM.buscarLibrosPorSeccion("Programación");
            for (Libro libro : libros) {
                System.out.println(libro.getTitulo());
                System.out.println(libro.getAutores());
                System.out.println(libro.getIsbn());
                System.out.println(libro.getNumeroPaginas());
                System.out.println(libro.getFechaPublicacion());
                System.out.println(libro.getPrecio());
                System.out.println(libro.getCopias());
                System.out.println("----------------------------");

            }

        } catch (SAXException | IOException e) {
            System.out.println("El documento XML no es válido.");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
