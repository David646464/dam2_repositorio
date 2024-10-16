package UD2.EJ1_3A1UD2;

import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        UtilXmlManager utilXmlManager = new UtilXmlManager("src/UD2/EJ1_3A1UD2/Empleados.xml");
        utilXmlManager.addNode(utilXmlManager.getFirstElement(), "empleado", null);
    }
}
