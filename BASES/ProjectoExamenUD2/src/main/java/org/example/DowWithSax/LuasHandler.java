package org.example.DowWithSax;

import org.w3c.dom.Element;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;



import java.util.HashMap;

public class LuasHandler extends DefaultHandler {
    private AccionesDOM accionesDOM;
    private HashMap<String, Boolean> indicador = new HashMap<>();
    String title = "";
    String estado = "";
    String data = "";
    String hora = "";

    public LuasHandler(AccionesDOM accionesDOM) {
        this.accionesDOM = accionesDOM;
    }

    @Override
    public void startDocument() throws SAXException {
        HashMap<String, String> atributos = new HashMap<>();
        atributos.put("Descripcion", "Fases Lunares");
        atributos.put("Servicio", "MeteoGalicia");

        accionesDOM.crearRoot("Lunas", atributos);
    }

    @Override
    public void endDocument() throws SAXException {
        accionesDOM.saveXmlChanges("Lunas2.xml");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (qName) {
            case "title":
                if (indicador.get("title") == null) {
                    indicador.put("title", true);
                } else {
                    indicador.put("titleItem", true);
                }
                break;
            case "estado":
                indicador.put("estado", true);
                break;
            case "data":
                indicador.put("data", true);
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case "title":
                if (indicador.get("titleItem") != null && indicador.get("titleItem")) {
                    indicador.put("titleItem", false);
                }
                break;
            case "estado":
                indicador.put("estado", false);
                break;
            case "data":
                indicador.put("data", false);
                break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (indicador.get("titleItem") != null && indicador.get("titleItem")) {
            title = new String(ch, start, length);
        } else if (indicador.get("estado") != null && indicador.get("estado")) {
           estado = new String(ch, start, length);
        } else if (indicador.get("data") != null && indicador.get("data")) {
            data = new String(ch, start, length).split(" ")[0];
            hora = new String(ch, start, length).split(" ")[1];
        }
    }
}
