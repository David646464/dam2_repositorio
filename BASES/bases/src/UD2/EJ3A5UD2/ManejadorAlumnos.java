package UD2.EJ3A5UD2;

import UD2.util.UtilXmlManager;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class ManejadorAlumnos {
    UtilXmlManager utilXmlManager ;
    public ManejadorAlumnos(String xmlOutputFile) throws ParserConfigurationException, IOException, SAXException {
        utilXmlManager = new UtilXmlManager(xmlOutputFile);
    }

    public void addAlumno(String nombre, int nota) throws ParserConfigurationException, IOException, SAXException {
        boolean notaExiste = existeNota(nota);

        if(notaExiste){
            NodeList notas = utilXmlManager.getElements("nota");
            for (int i = 0; i < notas.getLength(); i++) {
                if (notas.item(i).getAttributes().getNamedItem("valor").getNodeValue().equals(String.valueOf(nota))) {
                    Element alumno = utilXmlManager.getDocument().createElement("alumno");
                    alumno.setTextContent(nombre);
                    notas.item(i).appendChild(alumno);
                }
            }
        }else{
            Element notaElement = utilXmlManager.getDocument().createElement("nota");
            notaElement.setAttribute("valor", String.valueOf(nota));
            Element alumno = utilXmlManager.getDocument().createElement("alumno");
            alumno.setTextContent(nombre);
            notaElement.appendChild(alumno);
            //metre una nota a notas
            utilXmlManager.getElements("notas").item(0).appendChild(notaElement);
        }

        utilXmlManager.saveXmlChanges();
    }

    private boolean existeNota(int nota) {
        NodeList notas = utilXmlManager.getElements("nota");
        for (int i = 0; i < notas.getLength(); i++) {
            if (notas.item(i).getAttributes().getNamedItem("valor").getNodeValue().equals(String.valueOf(nota))) {
                return true;
            }
        }
        return false;
    }
}
