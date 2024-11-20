// main.java
package org.example.JABX;


import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class main {
    public static void main(String[] args) {
        try {
            // Crear el contexto JAXB y el unmarshaller
            JAXBContext context = JAXBContext.newInstance(Pesca.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            // Deserializar el archivo XML
            Pesca pesca = (Pesca) unmarshaller.unmarshal(new File("src/main/resources/pesca.xml"));

            // Crear el archivo de texto
            FileWriter writer = new FileWriter("src/main/resources/pesca.txt");

            // Escribir la información en el archivo de texto
            for (Xornada xornada : pesca.getXornadas()) {
                writer.write("Lugar: " + xornada.getLugar() + "\n");
                writer.write("Data: " + xornada.getData() + "\n");
                if (xornada.getCapturas() != null) {
                    for (Captura captura : xornada.getCapturas()) {
                        writer.write("Captura: " + captura.getEspecie() + ", Unidades: " + captura.getNumUnidades() + ", Peso: " + captura.getPeso() + "\n");
                    }
                }
                if (xornada.getDescricion() != null) {
                    writer.write("Descricion: " + xornada.getDescricion() + "\n");
                }
                writer.write("\n");
            }

            writer.close();
            System.out.println("Archivo pesca.txt generado correctamente.");

        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
    }
}