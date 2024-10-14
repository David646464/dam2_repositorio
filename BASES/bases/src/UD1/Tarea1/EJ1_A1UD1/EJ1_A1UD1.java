package UD1.Tarea1.EJ1_A1UD1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EJ1_A1UD1 {

    public static InputStreamReader reader = new InputStreamReader(System.in);
    public static BufferedReader bufferedReader = new BufferedReader(reader);

    public static void main(String[] args) throws IOException {
        System.out.println("Introduce primer numero entero:");
        int A = leerEntero();
        System.out.println("Introduce segundo numero entero:");
        int B = leerEntero();
        bufferedReader.close();
        reader.close();

        imprimirResultados(A,B);

    }

    private static void imprimirResultados(int A, int B) {
        System.out.println("La suma es: " + (A + B));
        System.out.println("La resta es: " + (A - B));
        System.out.println("La multiplicacion es: " + (A * B));
        if (B > A){
            System.out.println("La division es: " + (B / A));
            System.out.println("El resto: " + (B % A));
        }else{
            System.out.println("La division es: " + (A / B));
            System.out.println("El resto: " + (A % B));
        }
    }

    public static int leerEntero() throws IOException {

        int A =0;

        String texto = null;
        while (texto == null){
            try {
                texto = bufferedReader.readLine();
                A = Integer.parseInt(texto);
            }catch (Exception e){
                texto = null;
                System.out.println("No es un entero.Intentalo de nuevo:");
            }
        }
        return A;
    }

}