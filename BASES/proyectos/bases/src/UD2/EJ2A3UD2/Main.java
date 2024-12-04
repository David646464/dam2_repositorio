package UD2.EJ2A3UD2;

import UD2.EJ2_2A2UD2.MareaHandler;
import UD2.EJ2_3A2UD2.NoticiaHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        File file = new File("src/UD2/EJ2A3UD2/luas.xml");
        file.createNewFile();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        XMLReader xmlReader = saxParser.getXMLReader();
        LuasHandler handler = new LuasHandler();
        xmlReader.setContentHandler(handler);
        xmlReader.parse(new InputSource("https://servizos.meteogalicia.gal/mgrss/predicion/rssLuas.action?request_locale=gl"));
        //saxParser.parse("https://servizos.meteogalicia.gal/mgrss/predicion/rssLuas.action?request_locale=gl", handler);

    }
}
