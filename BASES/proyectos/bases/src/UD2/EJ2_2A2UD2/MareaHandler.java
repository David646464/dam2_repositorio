package UD2.EJ2_2A2UD2;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MareaHandler extends DefaultHandler {
    private boolean isMarea = false;
    private boolean isNomePorto = false;
    private boolean isData = false;
    private String estado;
    private String hora;
    private String altura;
    private String porto;
    private String data;


    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("Mareas:mareas")) {
            isMarea = true;
            estado = attributes.getValue("estado");
            hora = attributes.getValue("hora");
            altura = attributes.getValue("altura");
        } else if (qName.equalsIgnoreCase("Mareas:nomePorto")) {
            System.out.println("===========================================");
            isNomePorto = true;
        }else if (qName.equalsIgnoreCase("Mareas:dataPredicion")) {
            isData = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("Mareas:mareas")) {
            isMarea = false;
            System.out.println("Estado: " + estado + ", Hora: " + hora + ", Altura: " + altura);
        } else if (qName.equalsIgnoreCase("Mareas:nomePorto")) {
            isNomePorto = false;
        } else if ( qName.equalsIgnoreCase("Mareas:dataPredicion")) {
            isData = false;
            System.out.println("Porto: " + porto + ", Data: " + data);

        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isNomePorto) {
            porto = new String(ch, start, length);
        }else if (isData) {
            data = new String(ch, start, length);
        }
    }
}