package UD2.EJ1_2A1UD2;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EJ1_2A1UD2 {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        runcode();
    }

    private static void runcode() throws ParserConfigurationException, IOException, SAXException {
        UtilXmlManager utilXmlManager = new UtilXmlManager("src/UD2/EJ1_2A1UD2/Actores.xml");
        FileWriter fileWriter = new FileWriter("src\\UD2\\EJ1_2A1UD2\\Actores.txt");



        fileWriter.write(utilXmlManager.getElementsInfo());


        fileWriter.close();
    }
}
