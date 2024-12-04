package org.example.Pruebas;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        //Leer un json con los objetos de la carpeta Pruebas y imprimirlos
        // Leer el fichero JSON
        File file = new File("src/main/java/org/example/Documentos/BibliotecaInformatica.json");
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Biblioteca biblioteca = objectMapper.readValue(file, Biblioteca.class);
            System.out.println(biblioteca);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
