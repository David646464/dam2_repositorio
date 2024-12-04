//David sanchez Peso 77465294Y
package examen.ejercicio3;

import examen.ejercicio3.Objects.Programa;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;


import java.io.File;

public class Main {
    public static void main(String[] args) throws JAXBException {
        //
        JAXBContext context = JAXBContext.newInstance(Programa.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Programa programa = (Programa) unmarshaller.unmarshal(new File("src/main/java/examen/Documentos/medicionesRios.xml"));
        programa.imprimirInformacion();

    }
}
