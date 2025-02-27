package restget;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class RestPOST {

    public static void main(String[] args) {
        String strURL = "http://localhost/clientes/rest.php/clientes";
        String nombre = "Jamiroquai3";
        int codProvincia = 4;
        boolean vip = true;

        try {
            String parametros = "nombre=" + URLEncoder.encode(nombre, StandardCharsets.UTF_8.name()) +
                                "&codProvincia=" + codProvincia +
                                "&vip=" + (vip ? 1 : 0);

            URL url = new URL(strURL);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setDoOutput(true);
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            try (OutputStream os = con.getOutputStream()) {
                byte[] input = parametros.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            if (con.getResponseCode() == 201) {
                try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
                    String inputLine;
                    StringBuilder content = new StringBuilder();
                    while ((inputLine = in.readLine()) != null) {
                        content.append(inputLine);
                    }

                    Gson gson = new Gson();
                    JsonObject jsonResponse = gson.fromJson(content.toString(), JsonObject.class);
                    int codCliente = jsonResponse.get("codCliente").getAsInt();
                    System.out.println("Inserción correcta. Código de cliente: " + codCliente);
                }
            } else {
                System.out.println("Problemas. Respuesta: (" + con.getResponseCode() + ") " + con.getResponseMessage());
            }
        } catch (IOException ex) {
            System.out.println("Error en la conexión: " + ex.getMessage());
        }
    }

    public static void insertarCliente(Scanner sc) {
        System.out.print("Nombre: ");
        String nombre = sc.next();
        System.out.print("Código de provincia: ");
        int codProvincia = sc.nextInt();
        System.out.print("VIP (s/n): ");
        boolean vip = "s".equalsIgnoreCase(sc.next());

        String strURL = "http://localhost/clientes/rest.php/clientes";

        try {
            String parametros = "nombre=" + URLEncoder.encode(nombre, StandardCharsets.UTF_8.name()) +
                                "&codProvincia=" + codProvincia +
                                "&vip=" + (vip ? 1 : 0);

            URL url = new URL(strURL);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setDoOutput(true);
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            try (OutputStream os = con.getOutputStream()) {
                byte[] input = parametros.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            if (con.getResponseCode() == 201) {
                try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
                    String inputLine;
                    StringBuilder content = new StringBuilder();
                    while ((inputLine = in.readLine()) != null) {
                        content.append(inputLine);
                    }

                    Gson gson = new Gson();
                    JsonObject jsonResponse = gson.fromJson(content.toString(), JsonObject.class);
                    int codCliente = jsonResponse.get("codCliente").getAsInt();
                    System.out.println("Inserción correcta. Código de cliente: " + codCliente);
                }
            } else {
                System.out.println("Problemas. Respuesta: (" + con.getResponseCode() + ") " + con.getResponseMessage());
            }
        } catch (IOException ex) {
            System.out.println("Error en la conexión: " + ex.getMessage());
        }
    }
}