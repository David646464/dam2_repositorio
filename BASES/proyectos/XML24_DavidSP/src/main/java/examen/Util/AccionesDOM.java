//David sanchez Peso 77465294Y
package examen.Util;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.*;
import java.io.File;
import java.io.IOException;

public class AccionesDOM {
    private Document document;

    //Constructor
    public AccionesDOM(String xmlPath) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            this.document = builder.parse(new File(xmlPath));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Guarda el arbol dom en la ruta que se le pasa por parametro
    public void saveXmlChanges(String xmlPath) {
        try {

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();


            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");


            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File(xmlPath));


            quitarLineasVacias();


            transformer.transform(source, result);
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    //Quita las lineas vacias del dom paar guardar
    public void quitarLineasVacias() {
        removeEmptyTextNodes(document);
    }

    //Quita las lineas vacias del dom paar guardar
    private void removeEmptyTextNodes(Node node) {
        NodeList nodeList = node.getChildNodes();
        for (int i = nodeList.getLength() - 1; i >= 0; i--) {
            Node childNode = nodeList.item(i);
            if (childNode.getNodeType() == Node.TEXT_NODE && childNode.getTextContent().trim().isEmpty()) {
                node.removeChild(childNode);
            } else if (childNode.hasChildNodes()) {
                removeEmptyTextNodes(childNode);
            }
        }
    }

    //Valida el arbol dom con el xsd pasado por parametro
    public boolean validarContraEsquema(String s) {
        document.getDocumentElement().normalize();
        try {
            document.getDocumentElement().normalize();
            // Create a SchemaFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(true);
            factory.setNamespaceAware(true);
            factory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://www.w3.org/2001/XMLSchema");
            factory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaSource", new File(s));
            DocumentBuilder builder = factory.newDocumentBuilder();
            builder.parse(new File(s));
            return factory.isValidating();
        } catch (Exception e) {
            e.printStackTrace();


        }
        return false;
    }

    //valida el arbol dom con el dtd pasado por parametro
    public void validarConDTD(String s) throws IOException, SAXException, ParserConfigurationException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setValidating(true);
        DocumentBuilder analizador = dbf.newDocumentBuilder();
        analizador.setErrorHandler(
                new ErrorHandler() {
                    @Override
                    public void warning(SAXParseException e) throws SAXException {
                        System.out.println("WARNING : " + e.getMessage());
                    }

                    @Override
                    public void error(SAXParseException e) throws SAXException {
                        System.out.println("ERROR : " + e.getMessage());
                        //se puede lanzar la excepción e para que no siga con el procesam del doc XML
                        throw e;
                    }

                    @Override
                    public void fatalError(SAXParseException e) throws SAXException {
                        System.out.println("FATAL : " + e.getMessage());
                        throw e;
                    }
                }
        );
        Document documento = analizador.parse(new File(s));
        if (dbf.isValidating()) {
            System.out.println("El documento valida con el dtd");
        } else {
            System.out.println("El docuemnto valida con el dtd");
        }
    }

    //Busca por xpath un riio con una medida con una fecha expecifica
    public boolean buscarMedicionDeRioPorFecha(String codigo, String fecha) throws XPathExpressionException {

        String expression = "//Rio[@codigo='" + codigo + "']/Medicion[@fecha ='" + fecha + "']";


        NodeList nodeList = buscarPorXPhat(expression);
        if (nodeList.getLength() <= 0) {
            return false;
        } else {
            return true;
        }
    }

    //Busca un rio por su codigo con xpath
    private boolean buscarRio(String codigoRio) throws XPathExpressionException {
        String expression = "//Rio[@codigo='" + codigoRio + "']";
        NodeList nodeList = buscarPorXPhat(expression);
        if (nodeList.getLength() <= 0) {
            return false;
        } else {
            return true;
        }
    }

    //metodo general que modifica o crea los rios con sus medidas
    public void modificarElementoPorIdentificacor(String codigoRio, String nombreRio, String fecha, String phTipo, String phPorcentaje, String oxigenoValor, String temperaturaGrados, String calidad) throws XPathExpressionException {

        if (buscarMedicionDeRioPorFecha(codigoRio, fecha)) {
            String expression = "//Rio[@codigo='" + codigoRio + "']";

            NodeList nodeList = buscarPorXPhat(expression);

            Element element = (Element) nodeList.item(0);
            element.setAttribute("nombre", nombreRio);
            String medicionXpath = "//Rio[@codigo='" + codigoRio + "']/Medicion[@fecha ='" + fecha + "']";
            nodeList = buscarPorXPhat(medicionXpath);
            Element medicion = (Element) nodeList.item(0);
            medicion.setAttribute("calidad", calidad);

            Element ph = (Element) medicion.getElementsByTagName("pH").item(0);
            ph.setTextContent(phPorcentaje);
            ph.setAttribute("tipo", phTipo);
            Element Oxigeno = (Element) medicion.getElementsByTagName("Oxigeno").item(0);
            Oxigeno.setTextContent(oxigenoValor);
            Element Temperatura = (Element) medicion.getElementsByTagName("Temperatura").item(0);
            Temperatura.setTextContent(temperaturaGrados);
        } else if (buscarRio(codigoRio)) {
            String expression = "//Rio[@codigo='" + codigoRio + "']";
            NodeList nodeList = buscarPorXPhat(expression);
            Element rio = (Element) nodeList.item(0);
            Element Medicion = document.createElement("Medicion");
            Medicion.setAttribute("fecha", fecha);
            Medicion.setAttribute("calidad", calidad);
            Element pH = document.createElement("pH");
            pH.setAttribute("tipo", phTipo);
            pH.setTextContent(phPorcentaje);
            Element Oxigeno = document.createElement("Oxigeno");
            Oxigeno.setTextContent(oxigenoValor);
            Element Temperatura = document.createElement("Temperatura");
            Temperatura.setTextContent(temperaturaGrados);

            Medicion.appendChild(pH);
            Medicion.appendChild(Oxigeno);
            Medicion.appendChild(Temperatura);
            rio.appendChild(Medicion);
        } else {
            Element rio = document.createElement("Rio");
            rio.setAttribute("codigo", codigoRio);
            rio.setAttribute("nombre", nombreRio);
            Element Medicion = document.createElement("Medicion");
            Medicion.setAttribute("fecha", fecha);
            Medicion.setAttribute("calidad", calidad);
            Element pH = document.createElement("pH");
            pH.setAttribute("tipo", phTipo);
            pH.setTextContent(phPorcentaje);
            Element Oxigeno = document.createElement("Oxigeno");
            Oxigeno.setTextContent(oxigenoValor);
            Element Temperatura = document.createElement("Temperatura");
            Temperatura.setTextContent(temperaturaGrados);

            Medicion.appendChild(pH);
            Medicion.appendChild(Oxigeno);
            Medicion.appendChild(Temperatura);
            rio.appendChild(Medicion);
            Element rios = (Element) document.getElementsByTagName("Rios").item(0);
            rios.appendChild(rio);

        }
    }

    //Metdodo que trae un nodelst al pasarle un xpath
    private NodeList buscarPorXPhat(String xpath) throws XPathExpressionException {
        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xPath = xPathFactory.newXPath();
        XPathExpression xPathExpression = xPath.compile(xpath);
        NodeList nodeList = (NodeList) xPathExpression.evaluate(document, XPathConstants.NODESET);
        return nodeList;
    }
}
