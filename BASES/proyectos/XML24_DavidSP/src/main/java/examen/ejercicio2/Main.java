//David sanchez Peso 77465294Y
package examen.ejercicio2;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        MedicionesRiosHandler medicionesRiosHandler = new MedicionesRiosHandler(
                "src/main/java/examen/Documentos/medicionesRios.xml",
                "src/main/java/examen/Documentos/Actualizaciones.xsd",
                "src/main/java/examen/Documentos/Actualizaciones.xml");
        medicionesRiosHandler.actualizar();
    }
}
