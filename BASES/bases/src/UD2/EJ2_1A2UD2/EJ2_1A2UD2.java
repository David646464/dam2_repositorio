package UD2.EJ2_1A2UD2;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class EJ2_1A2UD2 {
    public static void main(String[] args) throws SAXException, IOException {
        XMLReader Analizador = XMLReaderFactory.createXMLReader();
        Analizador.parse(new InputSource(new FileInputStream("Actores.xml")));

    }
}
