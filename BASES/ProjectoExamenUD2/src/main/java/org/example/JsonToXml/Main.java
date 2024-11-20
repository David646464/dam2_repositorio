package org.example.JsonToXml;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        //pasar de json a xml
        try {
            File jsonFile = new File("src/main/java/org/example/Documentos/BibliotecaInformatica.json");
            File xmlFile = new File("src/main/java/org/example/Documentos/BibliotecaInformatica2.xml");

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(jsonFile);
            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.writeValue(xmlFile, jsonNode);
            System.out.println("Archivo XML creado");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
