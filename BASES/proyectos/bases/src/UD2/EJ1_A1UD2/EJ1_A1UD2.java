package UD2.EJ1_A1UD2;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class EJ1_A1UD2 {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        runcode();
    }

    private static void runcode() throws ParserConfigurationException, IOException, SAXException {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        while(opcion != 6){
            menu();
            opcion = sc.nextInt();
            switch (opcion){
                case 1-> validarXML();
                case 2-> validarXML();
            }
        }
    }

    private static void menu() {
        System.out.println("1. mostrar XML");

    }

    private static void validarXML() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        System.out.println("Documento valida: " + documentBuilderFactory.isValidating());
        documentBuilderFactory.setValidating(true);
        System.out.println("Documento valida: " + documentBuilderFactory.isValidating());
        System.out.println("Documento ignora espacios: " + documentBuilderFactory.isIgnoringElementContentWhitespace());
        documentBuilderFactory.setIgnoringElementContentWhitespace(true);
        System.out.println("Documento ignora espacios: " + documentBuilderFactory.isIgnoringElementContentWhitespace());
        System.out.println("Documento ignora comentarios: " + documentBuilderFactory.isIgnoringComments());
        documentBuilderFactory.setIgnoringComments(true);
        System.out.println("Documento ignora comentarios: " + documentBuilderFactory.isIgnoringComments());


        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        documentBuilder.setErrorHandler(new DefaultHandler());

        Document document = documentBuilder.parse(new File("src\\UD2\\EJ1_A1UD2\\Actores.xml"));

        System.out.println("Codificacion del xml" + document.getInputEncoding());
        System.out.println("=====================================");
        // Visualiza si tiene o no un DTD asociado. En el caso de que si tenga un DTD asociado, visualiza el
        //nombre del DTD.
        System.out.println(document.getDoctype() == null ? "No tiene DTD asociado" : document.getDoctype().getName());
        System.out.println("=====================================");
        //Visualiza el nombre del elemento raíz, el valor de este nodo y el número de hijos.
        System.out.println(document.getDocumentElement().getNodeName());
        System.out.println("=====================================");
        //Visualiza el texto contenido en el elemento raíz y de todos sus descendientes:
        System.out.println(document.getDocumentElement().getTextContent());
        System.out.println("=====================================");


        Node nodo=document.getDocumentElement();
        System.out.println("Nobre nodo:"+nodo.getNodeName()+ " Valor del nodo:" + nodo.getTextContent());
        System.out.println("=====================================");
        Element actorAux = null;
        NodeList actores = document.getElementsByTagName("Actor");
        for (int i = 0; i < /*actores.getLength()*/ 1; i++) {
            Element actor = (Element) actores.item(i);
            actorAux = actor;
            // Obtener el atributo 'id' del actor
            String id = actor.getAttribute("id");
            System.out.println("<id> " + id);

            // Obtener los hijos del nodo <Actor> (es decir, <Nome>, <Sexo>, <DataNacemento>)
            NodeList actorChildNodes = actor.getChildNodes();

            // Recorrer e imprimir las etiquetas y sus valores
            for (int j = 0; j < actorChildNodes.getLength(); j++) {
                Node childNode = actorChildNodes.item(j);

                // Asegurarse de que sea un nodo de tipo elemento
                if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                    System.out.println("<" + childNode.getNodeName() + "> " + childNode.getTextContent());
                }
            }
            System.out.println("=====================================");
        }

        //Obtener nodo hermano dos posicionnes a a derecha
        Node nodoHermano = actorAux.getNextSibling().getNextSibling();
        String id = nodoHermano.getAttributes().getNamedItem("id").getNodeValue();
        System.out.println("<id> " + id);
        NodeList actorChildNodes = nodoHermano.getChildNodes();

        // Recorrer e imprimir las etiquetas y sus valores
        for (int j = 0; j < actorChildNodes.getLength(); j++) {
            Node childNode = actorChildNodes.item(j);

            // Asegurarse de que sea un nodo de tipo elemento
            if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                System.out.println("<" + childNode.getNodeName() + "> " + childNode.getTextContent());
            }
        }
        System.out.println("=====================================");

        //A partir del nodo anterior, obtén información del nodo hermano izquierdo que está contiguo.
        Node nodoHermanoIzq = nodoHermano.getPreviousSibling();
        String idIzq = nodoHermanoIzq.getAttributes().getNamedItem("id").getNodeValue();
        System.out.println("<id> " + idIzq);
        NodeList actorChildNodesIzq = nodoHermanoIzq.getChildNodes();

        for (int j = 0; j < actorChildNodesIzq.getLength(); j++) {
            Node childNode = actorChildNodesIzq.item(j);

            // Asegurarse de que sea un nodo de tipo elemento
            if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                System.out.println("<" + childNode.getNodeName() + "> " + childNode.getTextContent());
            }
        }

        //Desde el objeto Document, visualiza los nombres de los nodos y sus valores de toda la estructura de
        //árbol DOM creada. Para ello crea un método recursivo
        System.out.println("=====================================");
        recorrerNodos(document.getDocumentElement());
        }

    private static void recorrerNodos(Element documentElement) {
        NodeList hijos = documentElement.getChildNodes();
        for (int i = 0; i < hijos.getLength(); i++) {
            Node nodo = hijos.item(i);
            if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                System.out.println("<" + nodo.getNodeName() + "> " + nodo.getTextContent());
                recorrerNodos((Element) nodo);
            }
        }
    }
}

