package UD2.EJ1A3UD2;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        //a
        /*try {
            ModificarActores.cambiarFechasPorFichero("src/UD2/EJ1A3UD2/Fechas.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        //b
        try {
            ModificarActores.addActor("src/UD2/EJ1A3UD2/Actores.xml", "A32,Michael Caine,home,1933-03-14");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //c
        ModificarActores.showActorInfo("src/UD2/EJ1A3UD2/Actores.xml", "A156");
    }
}
