package UD2.EJ1_A1UD2;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {
        public void main(String[] args) {
            UtilXmlManager utilXmlManager = new UtilXmlManager("src/UD2/EJ1_A1UD2/Actores2.xml");
            try {
                System.out.println(utilXmlManager.getElementsInfo());
            } catch (ParserConfigurationException | IOException | SAXException e) {
                e.printStackTrace();
            }
        }
}
