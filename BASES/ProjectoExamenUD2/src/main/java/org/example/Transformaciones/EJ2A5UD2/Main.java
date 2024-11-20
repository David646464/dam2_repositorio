package org.example.Transformaciones.EJ2A5UD2;

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
            //Xml hardware
            String xmlFile = "src/main/java/org/example/Transformaciones/EJ2A5UD2/hardware.xml";
            String xslFile = "src/main/java/org/example/Transformaciones/EJ2A5UD2/hardware.xsl";
            String xml2File = "src/main/java/org/example/Transformaciones/EJ2A5UD2/hardware2.xml";

            TransformerFactory factory = TransformerFactory.newInstance();

            Source xslt = new StreamSource(new File(xslFile));

            Transformer transformer = factory.newTransformer(xslt);

            Source xml = new StreamSource(new File(xmlFile));

            OutputStream xmlOutput = new FileOutputStream(xml2File);

            transformer.transform(xml, new StreamResult(xmlOutput));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
