package restget;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

class Cliente {
    private String nombre;
    private String apellidos;
    private String vip;
    private int codProvincia;

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public boolean isVip() {
        return "1".equals(vip);
    }

    public int getCodProvincia() {
        return codProvincia;
    }
}

public class RestGET {
    public static URL url = null;
    public static HttpURLConnection con = null;
    public static String json = "";
    public static String strURL = "http://localhost/clientes/rest.php/clientes";

    public static void imprimirClientes() {
        try {
            url = new URL(strURL);
            con = (HttpURLConnection) url.openConnection();
            con.connect();
            if (con.getResponseCode() == 200) {
                BufferedReader bufferIn = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String linea;
                while ((linea = bufferIn.readLine()) != null)
                    json += linea;
                bufferIn.close();

                // Imprimir el JSON recibido
                System.out.println("JSON recibido: " + json);

                // Analizar el JSON
                Gson gson = new Gson();
                List<Cliente> clientes = gson.fromJson(json, new TypeToken<List<Cliente>>() {}.getType());

                // Imprimir los clientes
                for (Cliente cliente : clientes) {
                    System.out.printf("%s %s de %d %s es VIP\n", cliente.getNombre(), cliente.getApellidos(), cliente.getCodProvincia(), cliente.isVip() ? "" : "no");
                }
            } else {
                System.out.println("Problemas. Respuesta: (" + con.getResponseCode() + ") " + con.getResponseMessage());
            }
        } catch (IOException ex) {
            System.out.println("Error en la conexión");
        }
    }

    public static void main(String[] args) {
        imprimirClientes();
    }
}