package org.example.DowWithSax;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

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
import java.util.HashMap;

public class AccionesDOM {
    private Document document;


    public AccionesDOM(Document document) {
        this.document = document;
    }

    public AccionesDOM() throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        this.document = builder.newDocument();
    }

    public AccionesDOM(String xmlPath) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            this.document = builder.parse(new File(xmlPath));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public void crearElemento(String nombre) {
        document.createElement(nombre);
    }

    public void crearAtributo(String nombre, String valor) {
        document.createAttribute(nombre).setValue(valor);
    }

    public void anadirElemento(String nombre, String valor) {
        document.createElement(nombre).appendChild(document.createTextNode(valor));
    }

    public void anadirElementoHijo(String nombre, String valor, String padre) {
        document.createElement(nombre).appendChild(document.createTextNode(valor));
        document.getElementsByTagName(padre).item(0).appendChild(document.createElement(nombre));
    }

    public void anadirAtributo(String nombre, String valor, String padre) {
        document.createAttribute(nombre).setValue(valor);
        Element element = (Element) document.getElementsByTagName(padre).item(0);
        element.setAttribute(nombre, valor);
    }



    public void saveXmlChanges(String xmlPath) {
        try {
            // Create a transformer factory and transformer
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            // Set output properties for indentation
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

            // Create a DOM source and stream result
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File(xmlPath));

            // Remove empty text nodes
            quitarLineasVacias();

            // Transform the document to the result
            transformer.transform(source, result);
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    public Element crearRoot(String nombre, HashMap<String, String> atributos){
        Element root = document.createElement(nombre);
        if (atributos != null) {
            for (String key : atributos.keySet()) {
                root.setAttribute(key, atributos.get(key));
            }
        }
        document.appendChild(root);
        return root;
    }

    public Element anadirElementoHijoARoot(String nombre, String valor, HashMap<String, String> atributos){
        Element nuevoElemento = document.createElement(nombre);
        nuevoElemento.setTextContent(valor);
        if (atributos != null) {
            for (String key : atributos.keySet()) {
                nuevoElemento.setAttribute(key, atributos.get(key));
            }
        }
        document.getDocumentElement().appendChild(nuevoElemento);
        return nuevoElemento;
    }

    public Element anadirElementoHijoAListaPorIdentificacor(String nombre, String valor, String padre, String identificador, String valorIdentificador, String padreLista, HashMap<String, String> atributos) {
        NodeList nodeList = document.getElementsByTagName(padre);
        Element nuevoElemento = null;
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element element = (Element) nodeList.item(i);
            if (element.getAttribute(identificador).equals(valorIdentificador)) {
                NodeList listaPadre = element.getElementsByTagName(padreLista);
                if (listaPadre.getLength() > 0) {
                    nuevoElemento = document.createElement(nombre);
                    nuevoElemento.setTextContent(valor);
                    if (atributos != null) {
                        for (String key : atributos.keySet()) {
                            nuevoElemento.setAttribute(key, atributos.get(key));
                        }
                    }
                    listaPadre.item(0).appendChild(nuevoElemento);
                }
                break;
            }
        }
        return nuevoElemento;
    }

    public void quitarLineasVacias() {
        removeEmptyTextNodes(document);
    }

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


    public Element anadirElementoHijoAListaPorIdentificacor(String padre, String identificador, String valorIdentificador, String nombre, String valor, HashMap<String, String> atributos) {
        NodeList nodeList = document.getElementsByTagName(padre);
        Element nuevoElemento = null;
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element element = (Element) nodeList.item(i);
            if (element.getAttribute(identificador).equals(valorIdentificador)) {
                 nuevoElemento = document.createElement(nombre);
                nuevoElemento.setTextContent(valor);
                if (atributos != null) {
                    for (String key : atributos.keySet()) {
                        nuevoElemento.setAttribute(key, atributos.get(key));
                    }
                }
                element.appendChild(nuevoElemento);
            }
        }
        return nuevoElemento;
    }


    public Element modificarElementoPorIdentificacor(String padre, String id, String valoridentificador, String nombre, String valor,HashMap<String, String> atributos) {
        NodeList nodeList = document.getElementsByTagName(padre);
        Element element1 = null;
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element element = (Element) nodeList.item(i);
            if (element.getAttribute(id).equals(valoridentificador)) {
                element1 = (Element) element.getElementsByTagName(nombre).item(0);
                element1.setTextContent(valor);
                if (atributos != null) {
                    for (String key : atributos.keySet()) {
                        element1.setAttribute(key, atributos.get(key));
                    }
                }
            }
        }
        return element1;
    }

    public Element modificarValorElementoPorIdentificacor(String padre, String id, String valoridentificador, String nombre, String valor) {
        NodeList nodeList = document.getElementsByTagName(padre);
        Element element1 = null;
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element element = (Element) nodeList.item(i);
            if (element.getAttribute(id).equals(valoridentificador)) {
                element1 = (Element) element.getElementsByTagName(nombre).item(0);
                element1.setTextContent(valor);
            }
        }
        return element1;
    }

    public Element modificarAtributoElementoPorIdentificacor(String padre, String id, String valoridentificador, String nombre, String valor) {
        NodeList nodeList = document.getElementsByTagName(padre);
        Element element = null;
        for (int i = 0; i < nodeList.getLength(); i++) {
             element = (Element) nodeList.item(i);
            if (element.getAttribute(id).equals(valoridentificador)) {
                element.setAttribute(nombre, valor);
            }
        }
        return element;
    }


    public Element eliminarElementoPorIdentificacor(String padre, String id, String valoridentificador, String nombre) {
        NodeList nodeList = document.getElementsByTagName(padre);
        Element element = null;
        for (int i = 0; i < nodeList.getLength(); i++) {
             element = (Element) nodeList.item(i);
            if (element.getAttribute(id).equals(valoridentificador)) {
                Element element1 = (Element) element.getElementsByTagName(nombre).item(0);
                element.removeChild(element1);
            }
        }
        return element;
    }

    public Element eliminarAtributoElementoPorIdentificacor(String padre, String id, String valoridentificador, String nombre) {
        NodeList nodeList = document.getElementsByTagName(padre);
        Element element = null;
        for (int i = 0; i < nodeList.getLength(); i++) {
            element = (Element) nodeList.item(i);
            if (element.getAttribute(id).equals(valoridentificador)) {
                element.removeAttribute(nombre);
            }
        }
        return element;
    }


    public Element anadirElementoHijo(Element element, String child, String value, Object atributes) {
        Element nuevoElemento = document.createElement(child);
        nuevoElemento.setTextContent(value);
        if (atributes != null) {
            for (String key : ((HashMap<String, String>) atributes).keySet()) {
                nuevoElemento.setAttribute(key, ((HashMap<String, String>) atributes).get(key));
            }
        }
        element.appendChild(nuevoElemento);
        return nuevoElemento;

    }
}
