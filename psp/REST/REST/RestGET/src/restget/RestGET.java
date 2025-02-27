package restget;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;



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

                Gson gson = new Gson();
                List<Cliente> clientes = gson.fromJson(json, new TypeToken<List<Cliente>>() {}.getType());
                int seleccion = -1;
                System.out.print("Selecciona un cliente: ");
                while (true) {
                    try {
                        seleccion = sc.nextInt();
                        if (seleccion > 0 && seleccion <= clientes.size()) {
                            Cliente cliente = clientes.get(seleccion - 1);
                            System.out.printf("%s %s de %d %s es VIP\n", cliente.getNombre(), cliente.getApellidos(), cliente.getCodProvincia(), cliente.isVip() ? "" : "no");
                        } else {
                            System.out.println("Selección fuera de rango. Volviendo al menú.");
                            break;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Entrada no válida. Por favor, introduce un número.");
                        sc.next(); // Limpiar el buffer del scanner
                    }
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

    public static int getClienteByIndex(int clienteIndex) {
        try {
            url = new URL(strURL);
            con = (HttpURLConnection) url.openConnection();
            con.connect();
            if (con.getResponseCode() == 200) {
                getClientes();
                Gson gson = new Gson();
                List<Cliente> clientes = gson.fromJson(json, new TypeToken<List<Cliente>>() {}.getType());
                Cliente cliente = clientes.get(clienteIndex - 1);
                return cliente.getCodCliente();
            } else {
                System.out.println("Problemas. Respuesta: (" + con.getResponseCode() + ") " + con.getResponseMessage());
            }
        } catch (IOException ex) {
            System.out.println("Error en la conexión");
        }
        return -1;
    }

    public static void imprimirCursosCliente(int codCliente) {
    try {
        url = new URL(strURL + "/" + codCliente + "/cursos");
        con = (HttpURLConnection) url.openConnection();
        con.connect();
        if (con.getResponseCode() == 200) {
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();

            Gson gson = new Gson();
            List<Curso> cursos = gson.fromJson(content.toString(), new TypeToken<List<Curso>>() {}.getType());

            System.out.println("CURSOS");
            for (Curso curso : cursos) {
                System.out.printf("ID: %d, Nombre: %s, Horas: %d\n", curso.getId(), curso.getNombre(), curso.getNumHoras());
            }
        } else {
            System.out.println("Problemas. Respuesta: (" + con.getResponseCode() + ") " + con.getResponseMessage());
        }
    } catch (IOException ex) {
        System.out.println("Error en la conexión");
    }
}

    public static int getCursoByIndex(int codCliente, int cursoIndex) {
    try {
        URL url = new URL(strURL + "/" + codCliente + "/cursos");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.connect();
        if (con.getResponseCode() == 200) {
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();

            Gson gson = new Gson();
            List<Curso> cursos = gson.fromJson(content.toString(), new TypeToken<List<Curso>>() {}.getType());
            Curso curso = cursos.get(cursoIndex - 1);
            return curso.getId();
        } else {
            System.out.println("Problemas. Respuesta: (" + con.getResponseCode() + ") " + con.getResponseMessage());
        }
    } catch (IOException ex) {
        System.out.println("Error en la conexión: " + ex.getMessage());
    }
    return -1;
}
}



