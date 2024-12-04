package UD2.EJ2_1A2UD2;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class EJ2_1A2UD2 {
    public static void main(String[] args) throws SAXException, IOException {
        String val = "http://xml.org/sax/features/validation";
        String namespaces = "http://xml.org/sax/features/namespaces";


        XMLReader Analizador = XMLReaderFactory.createXMLReader();


        if (Analizador.getFeature(val))
            System.out.println("Esta activada la validación");
        else {
            System.out.println("NO Esta activada la validación. Se va a establecer");
            Analizador.setFeature(val, true);
        }
        if (Analizador.getFeature(namespaces))
            System.out.println("Soporta espacios de nombres");
        else {
            System.out.println("NO soporta espacios de nombres. Se van a establecer");
            Analizador.setFeature(namespaces, true);
        }


        Analizador.parse(new InputSource(new FileInputStream("src\\UD2\\EJ2_1A2UD2\\Actores.xml")));


        /*C.-Visualiza la información del documento XML por pantalla y también guárdala en un fichero de texto,
        con el siguiente formato: Al final se debe visualizar el número total de actores.
        run:
        NO Esta activada la validación. Se va a establecer
        Soporta espacios de nombres
        Información de actores
        ==========================
        Actor 1
        **********
        id:51
        Nome:Eliabeth Shue
        Sexo:muller
        DataNacemento: 06/10/1963
        --------------------------------
        Actor 2
        ***********/


        // Set custom content handler
        ActorContentHandler handler = new ActorContentHandler();
        Analizador.setContentHandler(handler);

        // Parse the XML file
        Analizador.parse(new InputSource(new FileInputStream("src/UD2/EJ2_1A2UD2/Actores.xml")));

        // Print the total number of actors
        System.out.println("Número total de actores: " + handler.getActorCount());
    }
}

class ActorContentHandler extends DefaultHandler {
    private int actorCount = 0;
    private StringBuilder currentValue = new StringBuilder();
    private FileWriter fileWriter;

    public ActorContentHandler() throws IOException {
        fileWriter = new FileWriter("src/UD2/EJ2_1A2UD2/Actores.txt");
        fileWriter.write("Información de actores\n==========================\n");
    }

    public int getActorCount() {
        return actorCount;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentValue.setLength(0); // Clear the current value
        if (qName.equalsIgnoreCase("Actor")) {
            actorCount++;
            try {
                fileWriter.write("Actor " + actorCount + "\n**********\n");
                fileWriter.write("id: " + attributes.getValue("id") + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        currentValue.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        try {
            switch (qName) {
                case "Nome":
                    fileWriter.write("Nome: " + currentValue.toString() + "\n");
                    break;
                case "Sexo":
                    fileWriter.write("Sexo: " + currentValue.toString() + "\n");
                    break;
                case "DataNacemento":
                    fileWriter.write("DataNacemento: " + currentValue.toString() + "\n");
                    fileWriter.write("--------------------------------\n");
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void endDocument() throws SAXException {
        try {
            fileWriter.write("Número total de actores: " + actorCount + "\n");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
