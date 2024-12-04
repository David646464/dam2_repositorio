package EJ1A3UD2;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class ModificarActores {
    //Metodo que cambia las fechas de nacimiento de los actores por las que se encuentran en un fichero con estructura id,fecha
    public static void  cambiarFechasPorFichero(String fichero) throws ParserConfigurationException, IOException, SAXException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fichero));
        String linea;
        HashMap<String, String> fechas = new HashMap<>();
        while ((linea = bufferedReader.readLine()) != null) {
            String[] partes = linea.split(",");
            fechas.put(partes[0], partes[1]);
        }

        //Aqui se deberia recorrer el xml y cambiar las fechas de nacimiento de los actores por las que se encuentran en el hashmap
        UtilXmlManager utilXmlManager = new UtilXmlManager("src/EJ1A3UD2/Actores.xml");

        for (String id : fechas.keySet()) {
            String fecha = fechas.get(id);
            utilXmlManager.modifyElementById("Actor",id, "DataNacemento", fecha);
        }
        utilXmlManager.saveXmlChanges("src/EJ1A3UD2/Actores.dtd");




}

    public static void addActor(String s, String actorInfo) throws ParserConfigurationException, IOException, SAXException {
        String[] partes = actorInfo.split(",");

        UtilXmlManager utilXmlManager = new UtilXmlManager(s);
        if (!utilXmlManager.getElementExistenceById("Actor", partes[0])) {
            LinkedHashMap<String, String> atributes = new LinkedHashMap<>();
        atributes.put("id", partes[0]);
            LinkedHashMap<String, String> childElements = new LinkedHashMap<>();
        childElements.put("Nome", partes[1]);
        childElements.put("Sexo", partes[2]);
        childElements.put("DataNacemento", partes[3]);


        addElementActor("Actor", null, childElements, atributes, utilXmlManager.getDocument());
        utilXmlManager.saveXmlChanges("src/EJ1A3UD2/Actores.dtd");
        }else{
            System.out.println("El actor ya existe");
        }



    }

    private static Element addElementActor(String elementName, String content, HashMap<String, String> childElements, HashMap<String, String> atributes, Document document) {
        {
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
                    if(key.equals("DataNacemento")){
                        element1.setAttribute("formato", "dd/mm/aaaa");
                    }
                    element.appendChild(element1);
                }
            }
            document.getDocumentElement().appendChild(element);


            return element;
        }
    }

    public static void showActorInfo(String s, String id) throws ParserConfigurationException, IOException, SAXException {
        UtilXmlManager utilXmlManager = new UtilXmlManager(s);
        Element element = utilXmlManager.getElementById("Actor", id);

        if (element != null) {
            NodeList nodeList = element.getChildNodes();
            for (int i = 0; i < nodeList.getLength(); i++) {
                if (nodeList.item(i).getNodeType() == Element.ELEMENT_NODE) {
                    Element element1 = (Element) nodeList.item(i);
                    System.out.println(element1.getTagName() + ": " + element1.getTextContent());
                }
            }
        }else{
            System.out.println("El actor no existe");
        }
    }
}
