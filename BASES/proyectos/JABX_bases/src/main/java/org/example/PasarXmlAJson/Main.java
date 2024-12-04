package org.example.PasarXmlAJson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.example.PasarXmlAJson.Biblioteca;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            // Leer el fichero XML
            File file = new File("src/main/java/org/example/Documentos/BibliotecaInformatica.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Biblioteca.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Biblioteca biblioteca = (Biblioteca) unmarshaller.unmarshal(file);

            // Convertir a JSON
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            String json = objectMapper.writeValueAsString(biblioteca);

            // Escribir el JSON a un archivo
            FileWriter fileWriter = new FileWriter("src/main/java/org/example/Documentos/BibliotecaInformatica.json");
            fileWriter.write(json);
            fileWriter.close();

            System.out.println("JSON file created successfully!");

        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
    }
}