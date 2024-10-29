package UD2.EJ2_3A2UD2;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class EJ2_3A2UD2 {
    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            XMLReader xmlReader = saxParser.getXMLReader();
            NoticiaHandler handler = new NoticiaHandler();
            xmlReader.setContentHandler(handler);
            xmlReader.parse(new InputSource("https://feeds.elpais.com/mrss-s/pages/ep/site/elpais.com/portada"));
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

    }
}
