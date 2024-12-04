package EJ3A5UD2;



import UD2.util.UtilXmlManager;
import org.xml.sax.XMLReader;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class Main {
    public static void main(String[] args) {
        try {
            // Paths to the XML and XSL files
            String xmlFile = "src/EJ3A5UD2/Alumnos.xml";
            String xslFile = "src/EJ3A5UD2/Alumnos.xsl";
            String xmlOutputFile = "src/EJ3A5UD2/AlumnosOut.xml";

            TransformerFactory factory = TransformerFactory.newInstance();

            Source xslt = new StreamSource(new File(xslFile));

            Transformer transformer = factory.newTransformer(xslt);

            Source xml = new StreamSource(new File(xmlFile));

            OutputStream xmlOutput = new FileOutputStream(xmlOutputFile);

            transformer.transform(xml, new StreamResult(xmlOutput));

            //a) Se utilizarán flujos SAX tanto como para el origen como
            // para el destino de la transformación
            SAXParserFactory factory2 = SAXParserFactory.newInstance();

            SAXParser saxParser = factory2.newSAXParser();
            XMLReader xmlReader = saxParser.getXMLReader();

            AlumnosHandler handler = new AlumnosHandler();
            xmlReader.setContentHandler(handler);
            xmlReader.parse(xmlOutputFile);

            //b) Hacer lo mismo que en el anterior apartado, pero ahora el
            // documento se carga en memoria en un árbol
            //DOM, se añade un alumno nuevo y el destino de la
            // transformación lo recibirá el objeto SAXResult.

            ManejadorAlumnos manejadorAlumnos = new ManejadorAlumnos(xmlOutputFile);
            manejadorAlumnos.addAlumno("La sirenita", 10);
            manejadorAlumnos.addAlumno("Historias corrientes", 10);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
