package org.example.DowWithSax;

import org.w3c.dom.Element;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


import java.util.HashMap;

public class LuasHandler extends DefaultHandler {
    private AccionesDOM accionesDOM;
    private HashMap<String, Boolean> indicador = new HashMap<>();
    private String datahora = "";
    String estado = "";


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
            case "Luas:data":
                indicador.put("data", true);
                break;
            case "Luas:estado":
                indicador.put("estado", true);
                break;
            case "item":
                indicador.put("hora", true);
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("item")) {
            HashMap<String, String> atributos = new HashMap<>();
            atributos.put("Estado", estado);
            Element element = accionesDOM.anadirElementoHijoARoot("Lua", null, atributos);
            accionesDOM.anadirElementoHijo(element, "Fecha", datahora.split(" ")[0], null);
            element = accionesDOM.anadirElementoHijo(element, "Hora", datahora.split(" ")[1], null);

        }
        if (qName.equals("Luas:data")) {
            indicador.put("data", false);
        }
        if (qName.equals("Luas:estado")) {
            indicador.put("estado", false);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (indicador.get("data") != null && indicador.get("data")) {
            datahora = new String(ch, start, length);
            indicador.put("data", false);
        }
        if (indicador.get("estado") != null && indicador.get("estado")) {
            estado = new String(ch, start, length);
            indicador.put("estado", false);
        }

    }
}
