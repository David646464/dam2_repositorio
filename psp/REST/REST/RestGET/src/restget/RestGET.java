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
    private String vip;
    private int codProvincia;

    public String getNombre() {
        return nombre;
    }

    public boolean isVip() {
        return "1".equals(vip);
    }

    public int getCodProvincia() {
        return codProvincia;
    }
}

public class RestGET {

    public static void main(String[] args) {

        URL url = null;
        HttpURLConnection con = null;
        String json = "";
        String strURL = "http://localhost/clientes/rest.php/clientes";
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

                /* Analizamos el JSON devuelto, que sabemos que es un array de objetos cliente */
                Gson gson = new Gson();
                List<Cliente> clientes = gson.fromJson(json, new TypeToken<List<Cliente>>(){}.getType());
                for (Cliente cliente : clientes) {
                    System.out.printf("%s de %d %s es VIP\n", cliente.getNombre(), cliente.getCodProvincia(), cliente.isVip() ? "" : "no");
                }
            } else {
                System.out.println("Problemas.Respuesta: (" + con.getResponseCode() + ") " + con.getResponseMessage());
            }
        } catch (IOException ex) {
            System.out.println("Error en la conexión");
        }

    }

}