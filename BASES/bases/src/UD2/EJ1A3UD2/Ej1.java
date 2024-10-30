package UD2.EJ1A3UD2;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.crypto.dom.DOMCryptoContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Ej1 {

    static Document doc;

    public static void main(String[] args) {
//Configuracion para leer archivo xml
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            File file = new File("src/UD2/EJ1A3UD2/Actores2.xml");
            doc = builder.parse(file);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException(e);
        }
//a) Actualice el campo fecha de nacimiento. Los actores con las fechas a modificar provienen de un fichero detexto con el siguiente formato:

        leerFechasYActualizar("src/UD2/EJ1A3UD2/Fechas.txt");
        guardarDocumento("src/UD2/EJ1A3UD2/Actores2.xml");

//b) Añade al documento el actor id 32 Michael Caine nacido el 14 de Marzo de 1933

        addRegistro("1", "Victoria", "muller", "04/11/2004");
        guardarDocumento("src/UD2/EJ1A3UD2/Actores2.xml");

//c) Dado un id de actor nos visualice su información

        //mostrarInformacionActor("A50");
    }

    private static void guardarDocumento(String archivo) {
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            //Doctype
            transformer.setOutputProperty("doctype-system", "Actores.dtd");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(archivo));
            transformer.transform(source, result);
            System.out.println("Archivo XML actualizado");
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }
    }

    public static void reemplazarFecha(String cadena) {
        String tokends[] = cadena.split(",");

        Element actor = doc.getElementById(tokends[0]);
        if (actor != null) {
            Node datanac = actor.getElementsByTagName("DataNacemento").item(0);
            if (datanac != null) {
                datanac.getFirstChild().setNodeValue(tokends[1]);
            } else {
                System.out.println("El actor " + tokends[0] + " no tiene un elemento DataNacemento");
            }
        } else {
            System.out.println("No existe el actor " + tokends[0]);
        }
    }

    public static void leerFechasYActualizar(String archivoTexto) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivoTexto))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                reemplazarFecha(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de texto: " + e.getMessage());
        }
    }

    public static void addRegistro(String id, String nombre, String sexo, String fechaNac) {
        Element registro = doc.getElementById(id);
        if (registro != null) {
            System.out.println("existe el registro " + id);
        } else {
            registro = doc.createElement("Actor");
            registro.setAttribute("id", id);

// Crear los elementos hijo y establecer sus valores
            Element nombreElemento = doc.createElement("Nombre");
            nombreElemento.setTextContent(nombre);
            registro.appendChild(nombreElemento);

            Element sexoElemento = doc.createElement("Sexo");
            sexoElemento.setTextContent(sexo);
            registro.appendChild(sexoElemento);
        }
    }
}