package org.example.PasarXmlAJson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;

public class MainNodeJson {
    public static void main(String[] args) {
        try {

            File xmlFile = new File("src/main/java/org/example/Documentos/BibliotecaInformatica.xml");


            XmlMapper xmlMapper = new XmlMapper();
            JsonNode node = xmlMapper.readTree(xmlFile);


            ObjectMapper jsonMapper = new ObjectMapper();
            String jsonString = jsonMapper.writerWithDefaultPrettyPrinter().writeValueAsString(node);
            jsonMapper.writeValue(new File("src/main/java/org/example/Documentos/BibliotecaInformatica.json"), node);

            System.out.println(jsonString);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

