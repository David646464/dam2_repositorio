package org.example.Mareas;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URL;
import java.util.List;
import java.util.Map;

public class MainMapJson {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // URL del servicio web que proporciona los datos JSON
            String urlString = "https://servizos.meteogalicia.gal/mgrss/predicion/mareas/jsonMareas.action";
            URL url = new URL(urlString);

            // Leer los datos JSON desde la URL y convertirlos en un Map de Java
            Map<String, Object> jsonMap = objectMapper.readValue(url, new TypeReference<Map<String, Object>>() {});

            // Extraer la lista de mareas del Map principal
            List<Map<String, Object>> mareasList = (List<Map<String, Object>>) jsonMap.get("mareas");
            for (Map<String, Object> marea : mareasList) {
                // Extraer y mostrar la fecha de predicción y el nombre del puerto
                String data = (String) marea.get("data");
                String nomePorto = (String) marea.get("nomePorto");
                System.out.println("=====================");
                System.out.println("fecha prediccion: " + data + " puerto: " + nomePorto);

                // Iterar sobre la lista de detalles de mareas
                List<Map<String, Object>> listaMareas = (List<Map<String, Object>>) marea.get("listaMareas");
                for (Map<String, Object> detalleMarea : listaMareas) {
                    // Extraer y mostrar el tipo de marea, la hora y la altura
                    String tipoMarea = (String) detalleMarea.get("tipoMarea");
                    String hora = (String) detalleMarea.get("hora");
                    String altura = detalleMarea.get("altura").toString(); // Convertir a String
                    System.out.println("estado: " + tipoMarea + " hora: " + hora + " altura: " + altura);
                }
                System.out.println("=====================");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}