package restget;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class RestDelete {
    public static void borrarCliente(Scanner sc) {
        RestGET.imprimirClientes();
        System.out.print("Selecciona el cliente a borrar: ");
        int clienteIndex = sc.nextInt();
        int codCliente = RestGET.getClienteByIndex(clienteIndex);

        if (codCliente != -1) {
            System.out.println("Borrando cliente con codCliente: " + codCliente);
            borrarClientePorCodCliente(codCliente);
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    private static void borrarClientePorCodCliente(int codCliente) {
        String strURL = "http://localhost/clientes/rest.php/clientes/" + codCliente;
        try {
            URL url = new URL(strURL);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("DELETE");

            if (con.getResponseCode() == 204) {
                System.out.println("Cliente borrado correctamente.");
            } else {
                System.out.println("Problemas. Respuesta: (" + con.getResponseCode() + ") " + con.getResponseMessage());
            }
        } catch (IOException ex) {
            System.out.println("Error en la conexión: " + ex.getMessage());
        }
    }

    public static void borrarCursosCliente(Scanner sc) {
        RestGET.imprimirClientes();
        System.out.print("Selecciona el cliente para borrar sus cursos: ");
        int clienteIndex = sc.nextInt();
        int codCliente = RestGET.getClienteByIndex(clienteIndex);

        if (codCliente != -1) {
            System.out.println("Borrando cursos del cliente con codCliente: " + codCliente);
            borrarCursosClientePorCodCliente(codCliente);
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    private static void borrarCursosClientePorCodCliente(int codCliente) {
        String strURL = "http://localhost/clientes/rest.php/clientes/" + codCliente + "/cursos";
        try {
            URL url = new URL(strURL);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("DELETE");

            if (con.getResponseCode() == 204) {
                System.out.println("Cursos del cliente borrados correctamente.");
            } else {
                System.out.println("Problemas. Respuesta: (" + con.getResponseCode() + ") " + con.getResponseMessage());
            }
        } catch (IOException ex) {
            System.out.println("Error en la conexión: " + ex.getMessage());
        }
    }

    public static void borrarCursoCliente(Scanner sc) {
        RestGET.imprimirClientes();
        System.out.print("Selecciona el cliente para borrar un curso: ");
        int clienteIndex = sc.nextInt();
        int codCliente = RestGET.getClienteByIndex(clienteIndex);

        if (codCliente != -1) {
            System.out.println("Borrando curso del cliente con codCliente: " + codCliente);
            borrarCursoClientePorCodCliente(codCliente, sc);
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    private static void borrarCursoClientePorCodCliente(int codCliente, Scanner sc) {
        RestGET.imprimirCursosCliente(codCliente);
        System.out.print("Selecciona el curso a borrar: ");
        int cursoIndex = sc.nextInt();
        int codCurso = RestGET.getCursoByIndex(codCliente, cursoIndex);

        if (codCurso != -1) {
            System.out.println("Borrando curso con codCurso: " + codCurso);
            borrarCursoPorCodCurso(codCliente, codCurso);
        } else {
            System.out.println("Curso no encontrado.");
        }
    }

    private static void borrarCursoPorCodCurso(int codCliente, int codCurso) {
        String strURL = "http://localhost/clientes/rest.php/clientes/" + codCliente + "/cursos/" + codCurso;
        try {
            URL url = new URL(strURL);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("DELETE");

            if (con.getResponseCode() == 204) {
                System.out.println("Curso borrado correctamente.");
            } else {
                System.out.println("Problemas. Respuesta: (" + con.getResponseCode() + ") " + con.getResponseMessage());
            }
        } catch (IOException ex) {
            System.out.println("Error en la conexión: " + ex.getMessage());
        }
    }
}