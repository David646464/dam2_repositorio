//David sanchez Peso 77465294Y
package examen.ejercicio2;


import examen.Util.AccionesDOM;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;

public class MedicionesRiosHandler extends DefaultHandler {
    private AccionesDOM accionesDOM;
    private HashMap<String, Boolean> indicadores = new HashMap<>();
    private String xmlChangesRoot;
    private String codigoRio;
    private String nombreRio;
    private String fecha;
    private String phTipo;
    private String phPorcentaje;
    private String OxigenoValor;
    private String temperaturaGrados;
    private String Calidad;

    public MedicionesRiosHandler(String mxlOriginalRoot, String xsdroot, String xmlChangesRoot) {
        accionesDOM = new AccionesDOM(mxlOriginalRoot);
        AccionesDOM accionesDOM1 = new AccionesDOM(xmlChangesRoot);
        if (accionesDOM1.validarContraEsquema(xsdroot)) {
            System.out.println("El documento de Actualizaciones es correcto");
        } else {
            System.out.println("El documento de Actualizaciones es incorrectp");
        }
        this.xmlChangesRoot = xmlChangesRoot;

    }

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
    }

    @Override
    public void endDocument() throws SAXException {
        accionesDOM.saveXmlChanges("src/main/java/examen/Documentos/medicionesRiosOUT.xml");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (qName) {

            case "Rio" -> {
                indicadores.put("Rio", true);
                codigoRio = attributes.getValue("codigo");
            }
            case "Fecha" -> {
                indicadores.put("Fecha", true);
            }
            case "calidad" -> {
                indicadores.put("calidad", true);
            }
            case "pH" -> {
                phTipo = attributes.getValue("tipo");
                phPorcentaje = attributes.getValue("porcentaje");
            }
            case "Oxigeno" -> {
                OxigenoValor = attributes.getValue("valor");
            }
            case "Temperatura" -> {
                temperaturaGrados = attributes.getValue("grados");
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {

            case "Rio" -> {
                indicadores.put("Rio", false);
            }
            case "Fecha" -> {
                indicadores.put("Fecha", false);
            }
            case "calidad" -> {
                indicadores.put("calidad", false);
            }
            case "Entrada" -> {
                try {
                    accionesDOM.modificarElementoPorIdentificacor(
                            codigoRio,
                            nombreRio,
                            fecha,
                            phTipo,
                            phPorcentaje,
                            OxigenoValor,
                            temperaturaGrados,
                            Calidad
                    );
                } catch (XPathExpressionException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (indicadores.containsKey("Rio") && indicadores.get("Rio")) {
            nombreRio = new String(ch, start, length);
        } else if (indicadores.containsKey("Fecha") && indicadores.get("Fecha")) {
            String fechaSinConvertir = new String(ch, start, length);
            String[] fechaArray = fechaSinConvertir.split("/");
            fechaArray[1] = buscarMes(fechaArray[1]);
            fecha = fechaArray[0] + "-" + fechaArray[1] + "-" + fechaArray[2];
        } else if (indicadores.containsKey("calidad") && indicadores.get("calidad")) {
            Calidad = new String(ch, start, length);
        }
    }
    //A traves de un numero busca su respectivo acronimo
    private String buscarMes(String s) {
        String mes = "";
        switch (s) {
            case "01" -> {
                mes = "ene";
            }
            case "02" -> {
                mes = "feb";
            }
            case "03" -> {
                mes = "mar";
            }
            case "04" -> {
                mes = "abr";
            }
            case "05" -> {
                mes = "may";
            }
            case "06" -> {
                mes = "jun";
            }
            case "07" -> {
                mes = "jul";
            }
            case "08" -> {
                mes = "ago";
            }
            case "09" -> {
                mes = "sep";
            }
            case "10" -> {
                mes = "oct";
            }
            case "11" -> {
                mes = "nov";
            }
            case "12" -> {
                mes = "dic";
            }

        }
        return mes;
    }

    //Ejecuta el sax
    public void actualizar() throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        saxParser.parse(xmlChangesRoot, this);

    }
}
