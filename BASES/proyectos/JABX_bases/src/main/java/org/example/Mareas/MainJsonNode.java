package org.example.Mareas;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainJsonNode {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {

            String urlString =
                    "https://servizos.meteogalicia.gal/mgrss/predicion/mareas/jsonMareas.action";
            URL url = new URL(urlString);
            JsonNode rootNode = objectMapper.readTree(url);
            JsonNode mareasNode = rootNode.path("mareas");
            for (JsonNode mareaNode : mareasNode) {
                String data = mareaNode.path("data").asText();
                String nomePorto = mareaNode.path("nomePorto").asText();
                System.out.println("=====================");
                System.out.println("fecha prediccion: " + data + " puerto: " + nomePorto);
                JsonNode listaMareasNode = mareaNode.path("listaMareas");
                for (JsonNode detalleMareaNode : listaMareasNode) {
                    String tipoMarea = detalleMareaNode.path("tipoMarea").asText();
                    String hora = detalleMareaNode.path("hora").asText();
                    String altura = detalleMareaNode.path("altura").asText();
                    System.out.println("estado: " + tipoMarea + " hora: " + hora + " altura: " + altura);
                }
                System.out.println("=====================");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
