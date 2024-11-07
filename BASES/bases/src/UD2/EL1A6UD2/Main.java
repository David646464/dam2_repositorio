package UD2.EL1A6UD2;

import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.ParserConfigurationException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, JAXBException {
        Empresa empresa = new Empresa("Empresa", "12345678A");
        Empleado empleado1 = new Empleado("Empleado 1", "12345678A", 20);
        Empleado empleado2 = new Empleado("Empleado 2", "12345678B", 30);
        Empleado empleado3 = new Empleado("Empleado 3", "12345678C", 40);
        empresa.addEmpleado(empleado1);
        empresa.addEmpleado(empleado2);
        empresa.addEmpleado(empleado3);
        Empresas empresas = new Empresas();
        empresas.getLista().add(empresa);

        JAXBContext contexto = null;
        Marshaller m = null;
        try {
            contexto = JAXBContext.newInstance(Empresas.class);
            m = contexto.createMarshaller();
        } catch (JAXBException ex) {
            System.out.println("Error al crear el objeto Marshaller");
            ex.printStackTrace();
            return; // Salir del método si ocurre un error
        }

        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        m.marshal(empresas, System.out);

        // Mapear a un fichero
        try (Writer w = new FileWriter("src/UD2/EL1A6UD2/empresas.xml")) {
            m.marshal(empresas, w);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}