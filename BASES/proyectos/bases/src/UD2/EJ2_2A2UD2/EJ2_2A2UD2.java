package UD2.EJ2_2A2UD2;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class EJ2_2A2UD2 {
    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            MareaHandler handler = new MareaHandler();
            saxParser.parse("src/UD2/EJ2_2A2UD2/mareas.xml", handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
