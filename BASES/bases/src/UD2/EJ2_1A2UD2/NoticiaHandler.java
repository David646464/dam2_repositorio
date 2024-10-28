package UD2.EJ2_1A2UD2;

import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class NoticiaHandler extends DefaultHandler {
    private boolean isNoticia = false;
    private boolean isTitulo = false;
    private boolean isAutor = false;
    private boolean isData = false;
    private boolean isDescription = false;
    private String titulo;
    private String autor;
    private String data;
    private String contido;
    private boolean isCategory;
    private ArrayList<String> categorias = new ArrayList<>();

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws org.xml.sax.SAXException {
        if (qName.equalsIgnoreCase("title")) {
            isTitulo = true;
        } else if (qName.equalsIgnoreCase("dc:creator")) {
            isAutor = true;
        } else if (qName.equalsIgnoreCase("category")) {
            isCategory = true;
        } else if (qName.equalsIgnoreCase("description")) {
            isDescription = true;
        } else if (qName.equalsIgnoreCase("pubDate")) {
            isData = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws org.xml.sax.SAXException {
        if (qName.equalsIgnoreCase("title")) {
            imprimirCategorias();
            isTitulo = false;
            System.out.println("=============================================");
            System.out.println("Título: " + titulo);
        } else if (qName.equalsIgnoreCase("dc:creator")) {
            isAutor = false;
            System.out.println("Autor: " + autor);
        } else if (qName.equalsIgnoreCase("category")) {
            isCategory = false;
        } else if (qName.equalsIgnoreCase("description")) {
            isDescription = false;
            System.out.println("Contido: " + contido);
        } else if (qName.equalsIgnoreCase("pubDate")) {
            isData = false;
            System.out.println("Data: " + data);
        }
    }

    private void imprimirCategorias() {
        System.out.print("Categorías: ");
        for (String categoria : categorias) {
            System.out.print(categoria + "/");
        }
        System.out.println();
        categorias.clear();
    }

    @Override
    public void characters(char[] ch, int start, int length) throws org.xml.sax.SAXException {
        if (isTitulo) {
            titulo = new String(ch, start, length);
        } else if (isAutor) {
            autor = new String(ch, start, length);
        } else if (isCategory) {
            categorias.add(new String(ch, start, length));
        } else if (isDescription) {
            contido = new String(ch, start, length);
        } else if (isData) {
            data = new String(ch, start, length);
        }
    }
}
