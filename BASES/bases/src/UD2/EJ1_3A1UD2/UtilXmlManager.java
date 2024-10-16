package UD2.EJ1_3A1UD2;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class UtilXmlManager {
    private String xmlPath;
    private String txtPath;
    private Document document;
    public UtilXmlManager(String xmlPath, String txtPath) throws ParserConfigurationException, IOException, SAXException {
        this.xmlPath = xmlPath;
        this.txtPath = txtPath;
        document = getDocument();

    }

    public UtilXmlManager(String xmlPath) {
        this.xmlPath = xmlPath;
    }

    public String getXmlPath() {
        return xmlPath;
    }

    public void setXmlPath(String xmlPath) {
        this.xmlPath = xmlPath;
    }

    public String getTxtPath() {
        return txtPath;
    }

    public void setTxtPath(String txtPath) {
        this.txtPath = txtPath;
    }

    public Document getDocument() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(new File(xmlPath));
        return document;
    }

    //Metodo para hacer un string con toda la informacion de un xml
    public String getElementsInfo() throws ParserConfigurationException, IOException, SAXException {
        NodeList elements = getDocument().getChildNodes();
        int numeroElementos = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < elements.getLength(); i++) {
            Node element = elements.item(i);
            if (element.getNodeType() == Node.ELEMENT_NODE) {
                Element element1 = (Element) element;
                stringBuilder.append(element1.getTagName()).append("\n");
                if (element1.hasAttributes()){
                    stringBuilder.append(getEspacios(numeroElementos + 1)).append("Atributos: ").append("\n");
                    for (int j = 0; j < element1.getAttributes().getLength(); j++) {
                        stringBuilder.append(getEspacios(numeroElementos + 1)).append(element1.getAttributes().item(j).getNodeName()).append(": ").append(element1.getAttributes().item(j).getNodeValue()).append("\n");
                    }
                }
                if (element1.hasChildNodes()) {
                    stringBuilder.append(getElementsInfo(element1.getChildNodes(), numeroElementos + 1)).append("\n");
                }
            }
        }
        return stringBuilder.toString();
    }


    public String getElementsInfo(NodeList nodeList, int numero) throws ParserConfigurationException, IOException, SAXException {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node element = nodeList.item(i);
            if (element.getNodeType() == Node.ELEMENT_NODE) {
                Element element1 = (Element) element;
                stringBuilder.append(getEspacios(numero)).append(element1.getTagName()).append(": ").append(element1.getFirstChild().getTextContent()).append("\n");
                if (element1.hasAttributes()){
                    StringBuilder append = stringBuilder.append(getEspacios(numero + 1)).append("Atributos: ").append("\n");
                    for (int j = 0; j < element1.getAttributes().getLength(); j++) {
                        stringBuilder.append(getEspacios(numero + 1)).append(element1.getAttributes().item(j).getNodeName()).append(": ").append(element1.getAttributes().item(j).getNodeValue()).append("\n");
                    }
                    stringBuilder.append("\n");;
                }
                if (element1.hasChildNodes()) {
                    stringBuilder.append(getElementsInfo(element1.getChildNodes() ,numero +1));

                }
            }
        }
        return stringBuilder.toString();
    }

    public Element getFirstElement() throws ParserConfigurationException, IOException, SAXException {
        return getDocument().getDocumentElement();
    }

    public Element getFirtChildElement(NodeList nodeList) {
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node element = nodeList.item(i);
            if (element.getNodeType() == Node.ELEMENT_NODE) {
                return (Element) element;
            }
        }
        return null;
    }

    public boolean addNode(Element element, String tagName, String textContent) {
        if (textContent != null) {
            Element element1 = document.createElement(tagName);
            element1.setTextContent(textContent);
            element.appendChild(element1);
            return true;
        }else {
            Element element1 = document.createElement(tagName);
            element.appendChild(element1);
            return true;
        }
    }



    private String getEspacios(int i) {
        String espacios = "";
        for (int j = 0; j < i; j++) {
            espacios += "-";
        }
        return espacios;

    }
}



