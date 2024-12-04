package ExamenUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InputStreamReaderUtil {
    public static InputStreamReader reader = new InputStreamReader(System.in);
    public static BufferedReader bufferedReader = new BufferedReader(reader);

    public static int leerEntero() {
        int A = 0;
        String texto = null;
        while (texto == null) {
            try {
                System.out.println("Introduce un entero:");
                texto = bufferedReader.readLine();
                A = Integer.parseInt(texto);
            } catch (Exception e) {
                texto = null;
                System.out.println("No es un entero. Inténtalo de nuevo:");
            }
        }
        return A;
    }
    public static long leerLong() {
        long A = 0;
        String texto = null;
        while (texto == null) {
            try {
                System.out.println("Introduce un long:");
                texto = bufferedReader.readLine();
                A = Long.parseLong(texto);
            } catch (Exception e) {
                texto = null;
                System.out.println("No es un long. Inténtalo de nuevo:");
            }
        }
        return A;
    }
    public static float leerFloat() {
        float A = 0;
        String texto = null;
        while (texto == null) {
            try {
                System.out.println("Introduce un float:");
                texto = bufferedReader.readLine();
                A = Float.parseFloat(texto);
            } catch (Exception e) {
                texto = null;
                System.out.println("No es un float. Inténtalo de nuevo:");
            }
        }
        return A;
    }
    public static double leerDouble() {
        double A = 0;
        String texto = null;
        while (texto == null) {
            try {
                System.out.println("Introduce un double:");
                texto = bufferedReader.readLine();
                A = Double.parseDouble(texto);
            } catch (Exception e) {
                texto = null;
                System.out.println("No es un double. Inténtalo de nuevo:");
            }
        }
        return A;
    }
    public static String leerString() {
        String texto = null;
        while (texto == null) {
            try {
                System.out.println("Introduce un string:");
                texto = bufferedReader.readLine();
            } catch (Exception e) {
                texto = null;
                System.out.println("No es un string. Inténtalo de nuevo:");
            }
        }
        return texto;
    }

    public static void cerrarBufferedReader() {
        try {
            bufferedReader.close();
        } catch (Exception e) {
            System.out.println("Error al cerrar el bufferedReader");
        }
    }

    public static void cerrarReader() {
        try {
            reader.close();
        } catch (Exception e) {
            System.out.println("Error al cerrar el reader");
        }
    }
}
