package UD2.EJ1_3A1UD2;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        UtilXmlManager utilXmlManager = new UtilXmlManager("src/UD2/EJ1_3A1UD2/Empleados.xml");

        HashMap<String, String> map = new HashMap<>();
        map.put("Nombre", "Juan");
        map.put("Cargo", "Director");
        map.put("Direccion", "Calle");
        map.put("Aumento", "200");

        //utilXmlManager.addElementAtStart("Empleado", null, map ,null);
        //utilXmlManager.replaceElement(utilXmlManager.createElement("Empleado", null, null, map), 0 );
        //utilXmlManager.removeElement("Empleado", 0);
        //System.out.println(utilXmlManager.cloneElementAtFinal("Empleado", 0));
        /*utilXmlManager.addAtributeIdConsecutive("Empleado");
        Element element = utilXmlManager.cloneElement("Empleado", 0);
        element = utilXmlManager.modifyAtribute(element, "id", "15");
        element = utilXmlManager.modifyChildElementContent(element, "Nombre", "Maria Rivas Rivas");
        utilXmlManager.addElementFinal(element);
        System.out.println(utilXmlManager.getElementsInfo());*/
        System.out.println(utilXmlManager.getDocument().getDocumentURI());
    }
}
