//David Sánchez Peso v4
package UD2.EJ1A3UD2;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

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
import java.io.IOException;
import java.util.HashMap;

/**
 * The type Util xml manager.
 * Atributos:
 * xmlPath: String
 * txtPath: String
 * document: Document
 */
public class UtilXmlManager {
    private String xmlPath;
    private String txtPath;
    private Document document;

    /**
     * Instantiates a new Util xml manager.
     * Constructor que recibe el path del xml y el path del txt
     * @
     *
     * @param xmlPath the xml path
     * @param txtPath the txt path
     *Inicializa el atributo document con el xmlPath
     *
     * @throws ParserConfigurationException the parser configuration exception
     * @throws IOException                  the io exception
     * @throws SAXException                 the sax exception
     */
    public UtilXmlManager(String xmlPath, String txtPath) throws ParserConfigurationException, IOException, SAXException {
        this.xmlPath = xmlPath;
        this.txtPath = txtPath;
        document = getDocument(xmlPath);

    }

    /**
     * Instantiates a new Util xml manager.
     * Constructor que recibe el path del xml
     * @param xmlPath the xml path
     * Inicializa el atributo document con el xmlPath
     *
     * @throws ParserConfigurationException the parser configuration exception
     * @throws IOException                  the io exception
     * @throws SAXException                 the sax exception
     */
    public UtilXmlManager(String xmlPath) throws ParserConfigurationException, IOException, SAXException {
        this.xmlPath = xmlPath;
        document = getDocument(xmlPath);
    }

    /**
     * Sets document.
     *
     * @param document the document
     */
    public void setDocument(Document document) {
        this.document = document;
        xmlPath = document.getDocumentURI();
    }

    /**
     * Gets xml path.
     *
     * @return the xml path
     */
    public String getXmlPath() {
        return xmlPath;
    }

    /**
     * Sets xml path.
     *
     * @param xmlPath the xml path
     */
    public void setXmlPath(String xmlPath) throws ParserConfigurationException, IOException, SAXException {
        this.xmlPath = xmlPath;
        document = getDocument(xmlPath);
    }

    /**
     * Gets txt path.
     *
     * @return the txt path
     */
    public String getTxtPath() {
        return txtPath;
    }

    /**
     * Sets txt path.
     *
     * @param txtPath the txt path
     */
    public void setTxtPath(String txtPath) {
        this.txtPath = txtPath;
    }

    /**
     * Gets document.
     *
     * @return the document
     * @throws ParserConfigurationException the parser configuration exception
     * @throws IOException                  the io exception
     * @throws SAXException                 the sax exception
     */
    public Document getDocument() throws ParserConfigurationException, IOException, SAXException {
        return document;
    }


    /**
     * Gets document.
     *
     * @param path the path
     * @return the document
     * @throws ParserConfigurationException the parser configuration exception
     * @throws IOException                  the io exception
     * @throws SAXException                 the sax exception
     */
    public Document getDocument(String path) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        System.out.println(path);
        Document document = documentBuilder.parse(new File(path));
        return document;
    }

    /**
     * Gets elements info.
     *
     * @return the elements info
     * @throws ParserConfigurationException the parser configuration exception
     * @throws IOException                  the io exception
     * @throws SAXException                 the sax exception
     */
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
                if (element1.hasAttributes()) {
                    stringBuilder.append(getEspacios(numeroElementos + 1)).append("Atributos: ").append("\n");
                    for (int j = 0; j < element1.getAttributes().getLength(); j++) {
                        stringBuilder.append(getEspacios(numeroElementos + 1)).append(element1.getAttributes().item(j).getNodeName()).append(": ").append(element1.getAttributes().item(j).getNodeValue()).append("\n");
                    }
                    stringBuilder.append("\n");
                }
                if (element1.hasChildNodes()) {
                    stringBuilder.append(getElementsInfo(element1.getChildNodes(), numeroElementos + 1)).append("\n");
                }
            }
        }
        return stringBuilder.toString();
    }


    /**
     * Gets elements info.
     *
     * @param nodeList the node list
     * @param numero   the numero
     * @return the elements info
     * @throws ParserConfigurationException the parser configuration exception
     * @throws IOException                  the io exception
     * @throws SAXException                 the sax exception
     */
    public String getElementsInfo(NodeList nodeList, int numero) throws ParserConfigurationException, IOException, SAXException {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node element = nodeList.item(i);
            if (element.getNodeType() == Node.ELEMENT_NODE) {
                Element element1 = (Element) element;
                if (!element1.hasChildNodes()) {
                    stringBuilder.append(getEspacios(numero)).append(element1.getTagName()).append(": ").append("\n");
                } else {
                    stringBuilder.append(getEspacios(numero)).append(element1.getTagName()).append(": ").append(element1.getFirstChild().getTextContent().replaceFirst("^\\n", "")).append("\n");
                }
                if (element1.hasAttributes()) {
                    StringBuilder append = stringBuilder.append(getEspacios(numero + 1)).append("Atributos: ").append("\n");
                    for (int j = 0; j < element1.getAttributes().getLength(); j++) {
                        stringBuilder.append(getEspacios(numero + 1)).append(element1.getAttributes().item(j).getNodeName()).append(": ").append(element1.getAttributes().item(j).getNodeValue()).append("\n");
                    }
                    stringBuilder.append("\n");
                    ;
                }
                if (element1.hasChildNodes()) {
                    stringBuilder.append(getElementsInfo(element1.getChildNodes(), numero + 1));

                }
            }
        }
        return stringBuilder.toString();
    }

    /**
     * Gets first element.
     *
     * @return the first element
     * @throws ParserConfigurationException the parser configuration exception
     * @throws IOException                  the io exception
     * @throws SAXException                 the sax exception
     */
    public Element getFirstElement() throws ParserConfigurationException, IOException, SAXException {
        return getDocument().getDocumentElement();
    }

    /**
     * Gets firt child element.
     *
     * @param nodeList the node list
     * @return the firt child element
     */
    public Element getFirtChildElement(NodeList nodeList) {
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node element = nodeList.item(i);
            if (element.getNodeType() == Node.ELEMENT_NODE) {
                return (Element) element;
            }
        }
        return null;
    }

    /**
     * Add node boolean.
     *
     * @param element     the element
     * @param tagName     the tag name
     * @param textContent the text content
     * @return the boolean
     */
    public boolean addNode(Element element, String tagName, String textContent) {
        Element element1 = document.createElement(tagName);
        if (textContent != null) {
            element1.setTextContent(textContent);
        }
        element.appendChild(element1);
        return true;
    }

    /**
     * Add element element.
     *
     * @param elementName   the element name
     * @param content       the content
     * @param childElements the child elements
     * @param atributes     the atributes
     * @return the element
     */
//Añadir un nuevo empleado
    public Element addElement(String elementName, String content, HashMap<String, String> childElements, HashMap<String, String> atributes) {
        Element element = document.createElement(elementName);
        if (content != null) {
            element.setTextContent(content);
        }
        if (atributes != null) {
            for (String key : atributes.keySet()) {
                element.setAttribute(key, atributes.get(key));
            }
        }

        if (childElements != null) {
            for (String key : childElements.keySet()) {
                Element element1 = document.createElement(key);
                if (childElements.get(key) != null) {
                    element1.setTextContent(childElements.get(key));
                }
                element.appendChild(element1);
            }
        }
        document.getDocumentElement().appendChild(element);


        return element;
    }

    /**
     * Add element at start element.
     *
     * @param elementName   the element name
     * @param content       the content
     * @param childElements the child elements
     * @param atributes     the atributes
     * @return the element
     * @throws ParserConfigurationException the parser configuration exception
     * @throws IOException                  the io exception
     * @throws SAXException                 the sax exception
     */
    public Element addElementAtStart(String elementName, String content, HashMap<String, String> childElements, HashMap<String, String> atributes) throws ParserConfigurationException, IOException, SAXException {
        Element element = document.createElement(elementName);
        if (content != null) {
            element.setTextContent(content);
        }
        if (atributes != null) {
            for (String key : atributes.keySet()) {
                element.setAttribute(key, atributes.get(key));
            }
        }

        if (childElements != null) {
            for (String key : childElements.keySet()) {
                Element element1 = document.createElement(key);
                if (childElements.get(key) != null) {
                    element1.setTextContent(childElements.get(key));
                }
                element.appendChild(element1);
            }
        }
        document.getDocumentElement().insertBefore(element, document.getDocumentElement().getFirstChild());
        System.out.println(getElementsInfo());
        return element;
    }

    /**
     * Add atribute id consecutive boolean.
     *
     * @param elementName the element name
     * @return the boolean
     */
    public boolean addAtributeIdConsecutive(String elementName) {
        NodeList elements = document.getElementsByTagName(elementName);
        for (int i = 0; i < elements.getLength(); i++) {
            Element element = (Element) elements.item(i);
            element.setAttribute("id", String.valueOf(i + 1));
        }
        return true;

    }

    /**
     * Replace element element.
     *
     * @param element      the element
     * @param indexElemnet the index elemnet
     * @return the element
     */
    public Element replaceElement(Element element, int indexElemnet) {
        NodeList elements = document.getElementsByTagName(element.getTagName());
        Element element1 = (Element) elements.item(indexElemnet);
        element1.getParentNode().replaceChild(element, element1);
        return element1;
    }

    /**
     * Create element element.
     *
     * @param elementName   the element name
     * @param content       the content
     * @param atributes     the atributes
     * @param childElements the child elements
     * @return the element
     */
    public Element createElement(String elementName, String content, HashMap<String, String> atributes, HashMap<String, String> childElements) {
        Element element = document.createElement(elementName);
        if (content != null) {
            element.setTextContent(content);
        }
        if (atributes != null) {
            for (String key : atributes.keySet()) {
                element.setAttribute(key, atributes.get(key));
            }
        }
        if (childElements != null) {
            for (String key : childElements.keySet()) {
                Element element1 = document.createElement(key);
                if (childElements.get(key) != null) {
                    element1.setTextContent(childElements.get(key));
                }
                element.appendChild(element1);
            }
        }
        return element;
    }

    /**
     * Remove element boolean.
     *
     * @param elementName the element name
     * @param index       the index
     * @return the boolean
     */
    public boolean removeElement(String elementName, int index) {
        NodeList elements = document.getElementsByTagName(elementName);
        Element element = (Element) elements.item(index);
        element.getParentNode().removeChild(element);
        return true;
    }

    /**
     * Clone element at final boolean.
     *
     * @param elementName the element name
     * @param index       the index
     * @return the boolean
     */
    public boolean cloneElementAtFinal(String elementName, int index) {
        NodeList elements = document.getElementsByTagName(elementName);
        Element element = (Element) elements.item(index);
        Element clone = (Element) element.cloneNode(true);
        element.getParentNode().appendChild(clone);

        return true;
    }

    /**
     * Clone element at boolean.
     *
     * @param elementName the element name
     * @param index       the index
     * @param index2      the index 2
     * @return the boolean
     */
    public boolean cloneElementAt(String elementName, int index, int index2) {
        NodeList elements = document.getElementsByTagName(elementName);
        Element element = (Element) elements.item(index);
        Element clone = (Element) element.cloneNode(true);
        element.getParentNode().insertBefore(clone, element.getParentNode().getChildNodes().item(index2));
        return true;
    }

    /**
     * Clone element at start boolean.
     *
     * @param elementName the element name
     * @param index       the index
     * @return the boolean
     */
    public boolean cloneElementAtStart(String elementName, int index) {
        NodeList elements = document.getElementsByTagName(elementName);
        Element element = (Element) elements.item(index);
        Element clone = (Element) element.cloneNode(true);
        element.getParentNode().insertBefore(clone, element.getParentNode().getFirstChild());
        return true;
    }

    /**
     * Clone element element.
     *
     * @param elementName the element name
     * @param index       the index
     * @return the element
     */
    public Element cloneElement(String elementName, int index) {
        NodeList elements = document.getElementsByTagName(elementName);
        return (Element) elements.item(index);
    }

    /**
     * Add element final boolean.
     *
     * @param element the element
     * @return the boolean
     */
    public boolean addElementFinal(Element element) {
        document.getDocumentElement().appendChild(element);
        return true;
    }

    /**
     * Add element start boolean.
     *
     * @param element the element
     * @return the boolean
     */
    public boolean addElementStart(Element element) {
        document.getDocumentElement().insertBefore(element, document.getDocumentElement().getFirstChild());
        return true;
    }

    /**
     * Modify atribute element.
     *
     * @param element      the element
     * @param atributeName the atribute name
     * @param value        the value
     * @return the element
     */
    public Element modifyAtribute(Element element, String atributeName, String value) {
        element.setAttribute(atributeName, value);
        return element;
    }

    /**
     * Modify child element content element.
     *
     * @param element          the element
     * @param childElementName the child element name
     * @param value            the value
     * @return the element
     */
    public Element modifyChildElementContent(Element element, String childElementName, String value) {
        NodeList elements = element.getElementsByTagName(childElementName);
        Element element1 = (Element) elements.item(0);
        element1.setTextContent(value);
        return element;
    }

    /**
     * Modify child element content by index element.
     *
     * @param index            the index
     * @param elementName      the element name
     * @param childElementName the child element name
     * @param value            the value
     * @return the element
     */
    public Element modifyChildElementContentByIndex(int index, String elementName, String childElementName, String value) {
        NodeList elements = document.getElementsByTagName(elementName);
        //System.out.println(elements.getLength());
        Element element1 = (Element) elements.item(index);
        NodeList childNodes = element1.getElementsByTagName(childElementName);
        Element element2 = (Element) childNodes.item(0);
        element2.setTextContent(value);
        return element1;
    }

    private String getEspacios(int i) {
        return "-".repeat(Math.max(0, i));

    }

    public boolean modifyElementById(String elementName, String id, String childElementName, String value) {
        NodeList elements = document.getElementsByTagName(elementName);
        try {
            for (int i = 0; i < elements.getLength(); i++) {
                Element element = (Element) elements.item(i);
                if (element.getAttribute("id").equals(id)) {
                    NodeList childNodes = element.getElementsByTagName(childElementName);
                    Element element1 = (Element) childNodes.item(0);
                    element1.setTextContent(value);
                    return true;
                }
            }
        } catch (DOMException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public boolean addElementWithIndentation(String elementName, String content, HashMap<String, String> childElements, HashMap<String, String> attributes, int indentLevel) {
        try {
            StringBuilder elementBuilder = new StringBuilder();
            String indent = " ".repeat(indentLevel * 4); // 4 spaces per indent level

            elementBuilder.append(indent).append("<").append(elementName);

            if (attributes != null) {
                for (String key : attributes.keySet()) {
                    elementBuilder.append(" ").append(key).append("=\"").append(attributes.get(key)).append("\"");
                }
            }

            elementBuilder.append(">\n");

            if (content != null) {
                elementBuilder.append(indent).append("    ").append(content).append("\n");
            }

            if (childElements != null) {
                for (String key : childElements.keySet()) {
                    elementBuilder.append(indent).append("    <").append(key).append(">");
                    elementBuilder.append(childElements.get(key));
                    elementBuilder.append("</").append(key).append(">\n");
                }
            }

            elementBuilder.append(indent).append("</").append(elementName).append(">\n");

            // Append the new element as a string
            document.getDocumentElement().appendChild(document.createTextNode(elementBuilder.toString()));
            return true;
        } catch (DOMException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean saveXmlChanges(String dtdRoute) {
        try {
            // Create a transformer factory and transformer
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            // Set output properties for indentation
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

            // Add the DTD declaration
            transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "Actores.dtd");

            // Create a DOM source and stream result
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File(xmlPath));

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

    public boolean getElementExistenceById(String actor, String parte) {
        NodeList elements = document.getElementsByTagName(actor);
        for (int i = 0; i < elements.getLength(); i++) {
            Element element = (Element) elements.item(i);
            if (element.getAttribute("id").equals(parte)) {
                return true;
            }
        }
        return false;
    }

    public Element getElementById(String actor, String a32) {
        return document.getElementById(a32);
    }
}



