package org.example.UsarXPAHTYValidadcindeXSD;


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
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

    public Element crearRoot(String nombre, HashMap<String, String> atributos) {
        Element root = document.createElement(nombre);
        if (atributos != null) {
            for (String key : atributos.keySet()) {
                root.setAttribute(key, atributos.get(key));
            }
        }
        document.appendChild(root);
        return root;
    }

    public Element anadirElementoHijoARoot(String nombre, String valor, HashMap<String, String> atributos) {
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


    public Element modificarElementoPorIdentificacor(String padre, String id, String valoridentificador, String nombre, String valor, HashMap<String, String> atributos) {
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

    public void validarContraEsquema(String s) {
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
        } catch (Exception e) {
            e.printStackTrace();


        }
    }

    public List<Libro> buscarLibrosPorSeccion(String seccion) {
        List<Libro> libros = new ArrayList<>();
        try {
            // Crear una instancia de XPathFactory y XPath
            XPathFactory xPathFactory = XPathFactory.newInstance();
            XPath xPath = xPathFactory.newXPath();

            // Crear una expresión XPath para seleccionar los libros de una sección con atributo nombre X
            String expression = "//seccion[@nombre='" + seccion + "']/libros/libro";
            XPathExpression xPathExpression = xPath.compile(expression);

            // Evaluar la expresión XPath en el documento XML
            NodeList nodeList = (NodeList) xPathExpression.evaluate(document, XPathConstants.NODESET);

            // Iterar sobre los nodos resultantes y crear instancias de Libro
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);
                String id = element.getAttribute("ID").toString();
                String titulo = element.getAttribute("titulo").toString();
                String isbn = element.getAttribute("isbn").toString();
                String numeroPaginas = element.getAttribute("numero_de_paginas").toString();
                String fechaPublicacion = element.getElementsByTagName("fechaEdicion").item(0).getTextContent();
                String precio = element.getElementsByTagName("precio").item(0).getTextContent();
                List<String> autores = obtenerAutores(element.getElementsByTagName("autor"));
                List<String> copias = obtenerCopias(element.getElementsByTagName("copia"));
                Libro libro = new Libro(id, isbn, titulo, numeroPaginas, autores, fechaPublicacion, precio, copias);
                libros.add(libro);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return libros;
    }

    private List<String> obtenerCopias(NodeList copia) {
        List<String> listaCopias = new ArrayList<>();
        for (int i = 0; i < copia.getLength(); i++) {
            Element element = (Element) copia.item(i);
            String numero = element.getAttribute("numero").toString();
            String estado = element.getAttribute("estado").toString();
            listaCopias.add(numero + " " + estado);
        }
        return listaCopias;
    }

    private List<String> obtenerAutores(NodeList autores) {
        List<String> listaAutores = new ArrayList<>();
        for (int i = 0; i < autores.getLength(); i++) {
            listaAutores.add(autores.item(i).getTextContent());
        }
        return listaAutores;
    }


}
