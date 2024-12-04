//David sanchez Peso 77465294Y
package examen.ejercicio1;


import examen.Util.AccionesDOM;
import org.xml.sax.*;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {
        System.out.println("====================");
        //A Validar)
        AccionesDOM accionesDOM = new AccionesDOM("src/main/java/examen/Documentos/medicionesRios.xml");
        accionesDOM.validarConDTD("src/main/java/examen/Documentos/medicionesRios.xml");

        //B Buscar por codigo de rio y fecha)
        Boolean existe = accionesDOM.buscarMedicionDeRioPorFecha("R001","15-ene-2023");
        
        System.out.println(existe);
         System.out.println("====================");



    }
}
