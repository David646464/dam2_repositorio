package EJ1A4UD2;

import UD2.util.UtilXmlManager;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.HashMap;

public class ManejadorBiblioteca {
    private String xml;
    private String xsd;
    private UtilXmlManager utilXmlManager;
    private Document document;

    public ManejadorBiblioteca(String s, String s1) throws ParserConfigurationException, IOException, SAXException {
        utilXmlManager = new UtilXmlManager(s);
        utilXmlManager.validateXmlXSD(s1);
        document = utilXmlManager.getDocument();
    }


    public void parseXml() {
        NodeList nodeList = document.getElementsByTagName("biblioteca");
        System.out.println("Biblioteca:");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element element = (Element) nodeList.item(i);
            String facultad = element.getElementsByTagName("facultad").item(0).getTextContent();
            String campus = element.getElementsByTagName("Campus").item(0).getTextContent();
            System.out.println("Facultad: " + facultad);
            System.out.println("Campus: " + campus);

            NodeList nodeList1 = element.getElementsByTagName("seccion");
            for (int j = 0; j < nodeList1.getLength(); j++) {
                System.out.println("====================================");
                Element element1 = (Element) nodeList1.item(j);
                String nombre = element1.getAttribute("nombre");
                System.out.println("Sección: " + nombre);
                System.out.println("Libros:");
                NodeList nodeList2 = element1.getElementsByTagName("libro");
                for (int k = 0; k < nodeList2.getLength(); k++) {
                    Element element2 = (Element) nodeList2.item(k);
                    String isbn = element2.getAttribute("isbn");
                    String titulo = element2.getAttribute("titulo");
                    System.out.println("ISBN: " + isbn);
                    System.out.println("Título: " + titulo);
                    System.out.println("Autores:");
                    NodeList nodeList3 = element2.getElementsByTagName("autor");
                    for (int l = 0; l < nodeList3.getLength(); l++) {
                        Element element3 = (Element) nodeList3.item(l);
                        String autor = element3.getTextContent();
                        System.out.println("Autor: " + autor);
                    }
                    String fechaEdicion = element2.getElementsByTagName("fechaEdicion").item(0).getTextContent();
                    System.out.println("Fecha de edición: " + fechaEdicion);
                    String editorial = element2.getElementsByTagName("editorial").item(0).getTextContent();
                    System.out.println("Editorial: " + editorial);
                    String precio = element2.getElementsByTagName("precio").item(0).getTextContent();
                    System.out.println("Precio: " + precio);
                    System.out.println("Copias:");
                    NodeList nodeList4 = element2.getElementsByTagName("copia");
                    for (int m = 0; m < nodeList4.getLength(); m++) {
                        Element element4 = (Element) nodeList4.item(m);
                        String numero = element4.getAttribute("numero");

                        System.out.println("Numero: " + numero);
                        String estado = element4.getAttribute("estado");
                        System.out.println("Estado: " + estado);


                    }
                }
            }
        }
    }

    public void librosPorSeccion(String seccion) {
        StringBuilder sb = new StringBuilder();
        NodeList nodeList = document.getElementsByTagName("biblioteca");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element element = (Element) nodeList.item(i);
            NodeList nodeList1 = element.getElementsByTagName("seccion");
            for (int j = 0; j < nodeList1.getLength(); j++) {
                Element element1 = (Element) nodeList1.item(j);
                String nombre = element1.getAttribute("nombre");
                if (nombre.equals(seccion)) {
                    NodeList nodeList2 = element1.getElementsByTagName("libro");
                    for (int k = 0; k < nodeList2.getLength(); k++) {
                        sb.append("====================================\n");
                        Element element2 = (Element) nodeList2.item(k);
                        String ID = element2.getAttribute("ID");
                        String isbn = element2.getAttribute("isbn");
                        String titulo = element2.getAttribute("titulo");
                        String numero_de_paginas = element2.getAttribute("numero_de_paginas");
                        sb.append("ID: ").append(ID).append("\n");
                        sb.append("ISBN: ").append(isbn).append("\n");
                        sb.append("Título: ").append(titulo).append("\n");
                        sb.append("Número de páginas: ").append(numero_de_paginas).append("\n");
                        NodeList nodeList3 = element2.getElementsByTagName("autor");
                        if (nodeList3 != null){
                            sb.append("Autores: [");
                        }
                        for (int l = 0; l < nodeList3.getLength(); l++) {
                            Element element3 = (Element) nodeList3.item(l);
                            String autor = element3.getTextContent();
                            sb.append(autor + ",");
                        }
                        if (nodeList3 != null){
                            sb.append("]\n");
                        }
                        String fechaEdicion = element2.getElementsByTagName("fechaEdicion").item(0).getTextContent();
                        sb.append("Fecha de edición: ").append(fechaEdicion).append("\n");
                        String editorial = element2.getElementsByTagName("editorial").item(0).getTextContent();
                        sb.append("Editorial: ").append(editorial).append("\n");
                        String precio = element2.getElementsByTagName("precio").item(0).getTextContent();
                        sb.append("Precio: ").append(precio).append("\n");

                        NodeList nodeList4 = element2.getElementsByTagName("copia");
                        if (nodeList4 != null){
                            sb.append("Copias:\n");
                        }
                        for (int m = 0; m < nodeList4.getLength(); m++) {
                            Element element4 = (Element) nodeList4.item(m);
                            String numero = element4.getAttribute("numero");


                            String estado = element4.getAttribute("estado");
                            sb.append("{Número de copia: ").append(numero).append(", Estado: ").append(estado).append("}\n");
                        }
                    }
                }
            }
        }
        System.out.println(sb.toString());
    }

    public void secionesOrdenadasPorNumLibros() {
        HashMap<String, Integer> map = new HashMap<>();
        NodeList nodeList = document.getElementsByTagName("biblioteca");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element element = (Element) nodeList.item(i);
            NodeList nodeList1 = element.getElementsByTagName("seccion");
            for (int j = 0; j < nodeList1.getLength(); j++) {
                Element element1 = (Element) nodeList1.item(j);
                String nombre = element1.getAttribute("nombre");
                NodeList nodeList2 = element1.getElementsByTagName("libro");
                map.put(nombre, nodeList2.getLength());
            }
        }

        map.entrySet().stream()
                .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                .forEach(entry -> {
                    System.out.println("====================================");
                    System.out.println("Sección: " + entry.getKey());
                    System.out.println("Número de libros: " + entry.getValue());
                });
    }

    public void modificarEstadoCopia(String isbn, int numeroCopia, String nuevoEstado) {
        if (document == null) {
            System.out.println("El documento XML es nulo.");
            return;
        }

        NodeList nodeList = document.getElementsByTagName("biblioteca");
        for (int j = 0; j < nodeList.getLength(); j++) {
            Element element = (Element) nodeList.item(j);
            NodeList nodeList1 = element.getElementsByTagName("seccion");
            for (int k = 0; k < nodeList1.getLength(); k++) {
                Element element1 = (Element) nodeList1.item(k);
                NodeList nodeList2 = element1.getElementsByTagName("libro");
                for (int l = 0; l < nodeList2.getLength(); l++) {
                    Element element2 = (Element) nodeList2.item(l);
                    if (element2.getAttribute("isbn").equals(isbn)) {
                        NodeList nodeList3 = element2.getElementsByTagName("copia");
                        for (int m = 0; m < nodeList3.getLength(); m++) {
                            Element element3 = (Element) nodeList3.item(m);
                            int numero = Integer.parseInt(element3.getAttribute("numero"));
                            if (numero == numeroCopia) {
                                element3.setAttribute("estado", nuevoEstado);
                                System.out.println("Estado de la copia actualizado.");
                            }
                        }
                    }
                }
            }
        }

        try {
            utilXmlManager.saveDocumentXSLT(document);
            System.out.println("Documento XML guardado correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al guardar el documento XML.");
        }
    }

    public void anadirLibroASeccion(Libro libro, String programación) {
        //Revisar que no exista el ISBN del libro
        NodeList nodeList = document.getElementsByTagName("biblioteca");
        for (int j = 0; j < nodeList.getLength(); j++) {
            Element element = (Element) nodeList.item(j);
            NodeList nodeList1 = element.getElementsByTagName("seccion");
            for (int k = 0; k < nodeList1.getLength(); k++) {
                Element element1 = (Element) nodeList1.item(k);
                NodeList nodeList2 = element1.getElementsByTagName("libro");
                for (int l = 0; l < nodeList2.getLength(); l++) {
                    Element element2 = (Element) nodeList2.item(l);
                    if (element2.getAttribute("isbn").equals(libro.getIsbn())) {
                        System.out.println("El ISBN del libro ya existe.");
                        return;
                    }
                }
            }
        }
        //Añadir el libro a la sección
        for (int j = 0; j < nodeList.getLength(); j++) {
            Element element = (Element) nodeList.item(j);
            NodeList nodeList1 = element.getElementsByTagName("seccion");
            for (int k = 0; k < nodeList1.getLength(); k++) {
                Element element1 = (Element) nodeList1.item(k);
                if (element1.getAttribute("nombre").equals(programación)) {
                    Element libroElement = document.createElement("libro");
                    libroElement.setAttribute("ID", libro.getID());
                    libroElement.setAttribute("isbn", libro.getIsbn());
                    libroElement.setAttribute("titulo", libro.getTitulo());
                    libroElement.setAttribute("numero_de_paginas", String.valueOf(libro.getNumero_de_paginas()));
                    Element autoresElement = document.createElement("autores");
                    for (String autor : libro.getAutores()) {
                        Element autorElement = document.createElement("autor");
                        autorElement.setTextContent(autor);
                        autoresElement.appendChild(autorElement);
                    }
                    libroElement.appendChild(autoresElement);
                    Element fechaEdicionElement = document.createElement("fechaEdicion");
                    fechaEdicionElement.setTextContent(libro.getFechaEdicion().toString());
                    libroElement.appendChild(fechaEdicionElement);
                    Element editorialElement = document.createElement("editorial");
                    editorialElement.setTextContent(libro.getEditorial());
                    libroElement.appendChild(editorialElement);
                    Element precioElement = document.createElement("precio");
                    precioElement.setTextContent(String.valueOf(libro.getPrecio()));
                    libroElement.appendChild(precioElement);
                    Element copiasElement = document.createElement("copias");
                    for (Copia copia : libro.getCopias()) {
                        Element copiaElement = document.createElement("copia");
                        copiaElement.setAttribute("numero", String.valueOf(copia.getNumero()));
                        copiaElement.setAttribute("estado", copia.getEstado());
                        copiasElement.appendChild(copiaElement);
                    }
                    libroElement.appendChild(copiasElement);
                    element1.getFirstChild().appendChild(libroElement);
                }
            }
        }

        //Guardar el documento XML
        try {
            utilXmlManager.saveDocumentXSLT(document);
            System.out.println("Documento XML guardado correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al guardar el documento XML.");
        }

    }
}
