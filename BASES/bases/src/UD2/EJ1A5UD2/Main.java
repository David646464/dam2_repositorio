package UD2.EJ1A5UD2;

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
            String xmlFile = "src/UD2/EJ1A5UD2/Actores.xml";
            String xslFile = "src/UD2/EJ1A5UD2/Actores.xsl";
            String htmlFile = "src/UD2/EJ1A5UD2/Actores.html";

            TransformerFactory factory = TransformerFactory.newInstance();

            Source xslt = new StreamSource(new File(xslFile));

            Transformer transformer = factory.newTransformer(xslt);

            Source xml = new StreamSource(new File(xmlFile));

            OutputStream htmlOutput = new FileOutputStream(htmlFile);

            transformer.transform(xml, new StreamResult(htmlOutput));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
