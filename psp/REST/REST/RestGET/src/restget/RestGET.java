package restget;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

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
               getClientes();

                // Imprimir el JSON recibido
                //System.out.println("JSON recibido: " + json);

                // Analizar el JSON
                Gson gson = new Gson();
                List<Cliente> clientes = gson.fromJson(json, new TypeToken<List<Cliente>>() {
                }.getType());

                int i = 1;
                // Imprimir los clientes
                System.out.println("CLIENTES");
                for (Cliente cliente : clientes) {
                    System.out.printf(i + " %s %s de %d %s es VIP\n", cliente.getNombre(), cliente.getApellidos(), cliente.getCodProvincia(), cliente.isVip() ? "" : "no");
                    i++;
                }
            } else {
                System.out.println("Problemas. Respuesta: (" + con.getResponseCode() + ") " + con.getResponseMessage());
            }
        } catch (IOException ex) {
            System.out.println("Error en la conexión");
        }
    }

    public static void seleccionarCliente(Scanner sc) {
        imprimirClientes();
        try {
            url = new URL(strURL);
            con = (HttpURLConnection) url.openConnection();
            con.connect();
            if (con.getResponseCode() == 200) {
              getClientes();

                // Imprimir el JSON recibido
                //System.out.println("JSON recibido: " + json);

                // Analizar el JSON
                Gson gson = new Gson();
                List<Cliente> clientes = gson.fromJson(json, new TypeToken<List<Cliente>>() {}.getType());
                int seleccion = -1;
                System.out.print("Selecciona un cliente: ");
                while (((seleccion = sc.nextInt()) >0) && (seleccion <= clientes.size())){
                    Cliente cliente = clientes.get(seleccion-1);
                     System.out.printf("%s %s de %d %s es VIP\n", cliente.getNombre(), cliente.getApellidos(), cliente.getCodProvincia(), cliente.isVip() ? "" : "no");
                }

            } else {
                System.out.println("Problemas. Respuesta: (" + con.getResponseCode() + ") " + con.getResponseMessage());
            }
        } catch (IOException ex) {
            System.out.println("Error en la conexión");
        }
    }

private static  void getClientes() {
        try {
            json ="";
              BufferedReader bufferIn = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String linea;
                while ((linea = bufferIn.readLine()) != null)
                    json += linea;
                bufferIn.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
}

public static void main(String[] args) {
        RestGET.imprimirClientes();
    }

}



