package EJ2A3UD2;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;


public class LuasHandler extends DefaultHandler {
    private static Document doc;

    static {
        try {
            doc = createDoc();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
    }

    private static Document createDoc() throws ParserConfigurationException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document doc = documentBuilder.newDocument();
        return doc;
    }

    private static String TituloChannel, TituloItem;
    private static boolean isTituloChannel = false;
    private static boolean isTituloItem = false;
    private static boolean isTituloChannelAnterior = false;
    private static boolean isFecha = false;
    private static boolean isEstado = false;
    private static String fecha, hora, estado;

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws org.xml.sax.SAXException {
        if (qName.equalsIgnoreCase("title")) {
            if (isTituloChannelAnterior) {
                isTituloChannel = true;
            } else {
                isTituloItem = true;
            }
        } else if (qName.equalsIgnoreCase("channel")) {
            isTituloChannelAnterior = true;
        } else if (qName.equalsIgnoreCase("item")) {
            isTituloChannelAnterior = false;
        } else if (qName.equalsIgnoreCase("Luas:data")) {
            isFecha = true;
        } else if (qName.equalsIgnoreCase("Luas:estado")) {
            isEstado = true;
        }

    }


    @Override
    public void endElement(String uri, String localName, String qName) throws org.xml.sax.SAXException {
        if (qName.equalsIgnoreCase("title")) {
            if (isTituloChannel) {
                isTituloChannel = false;
                Element Lunas = doc.createElement("Lunas");
                Lunas.setAttribute("Descripcion", TituloChannel);
                Lunas.setAttribute("Servicio", "MeteoGalicia");
                doc.appendChild(Lunas);
            } else {
                isTituloItem = false;
                Element Item = doc.createElement("Luna");
                Item.setAttribute("Estado", estado);
                Element Fecha = doc.createElement("Fecha");
                Fecha.setTextContent(fecha);
                Fecha.appendChild(doc.createTextNode(fecha));
                Element Hora = doc.createElement("Hora");
                Hora.setTextContent(hora);
                Hora.appendChild(doc.createTextNode(hora));
                Item.appendChild(Fecha);
                Item.appendChild(Hora);
                NodeList nodeList = doc.getElementsByTagName("Lunas");
                nodeList.item(nodeList.getLength() - 1).appendChild(Item);
            }
        } else if (qName.equalsIgnoreCase("Luas:data")) {
            isFecha = false;
        } else if (qName.equalsIgnoreCase("Luas:estado")) {
            isEstado = false;

        } else if (qName.equalsIgnoreCase("channel")) {
            saveXmlChanges();
        }


    }

    @Override
    public void characters(char[] ch, int start, int length) throws org.xml.sax.SAXException {
        if (isTituloChannel) {
            TituloChannel = new String(ch, start, length);
        } else if (isTituloItem) {
            TituloItem = new String(ch, start, length);
        } else if (isFecha) {
            fecha = new String(ch, start, length).split(" ")[0];
            hora = new String(ch, start, length).split(" ")[1];
        } else if (isEstado) {
            estado = new String(ch, start, length);
        }
    }

    public boolean saveXmlChanges() {
        if (doc == null) {
            System.out.println("El documento XML es nulo.");
            return false;
        }

        if (doc.getDocumentElement() == null) {
            System.out.println("El documento XML no tiene un elemento raíz.");
            return false;
        }

        try {
            // Create a transformer factory and transformer
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            // Set output properties for indentation
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

            // Create a DOM source and stream result
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("src/EJ2A3UD2/luas.xml"));

            // Remove empty text nodes
            quitarLineasVacias();

            // Transform the document to the result
            transformer.transform(source, result);
            return true;
        } catch (TransformerException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void quitarLineasVacias() {
        removeEmptyTextNodes(doc);
    }

    private static void removeEmptyTextNodes(Node node) {
        NodeList nodeList = node.getChildNodes();
        for (int i = nodeList.getLength() - 1; i >= 0; i--) {
            Node childNode = nodeList.item(i);
            if (childNode.getNodeType() == Node.TEXT_NODE
                    && childNode.getTextContent() != null
                    && childNode.getTextContent().trim().isEmpty()) {
                node.removeChild(childNode);
            } else {
                removeEmptyTextNodes(childNode);
            }

        }
    }
}
