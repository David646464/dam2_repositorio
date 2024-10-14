package UD2.EJ1_A1UD2;

import org.w3c.dom.Document;
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
            opcion = sc.nextInt();
            switch (opcion){
                case 1-> validarXML();
                case 2-> validarXML();
            }
        }
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

        }
    }

