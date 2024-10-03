package Tarea1.EJ2_A1UD1;

import java.io.*;

public class EJ2A_A1UD1 {
    public static InputStreamReader reader = new InputStreamReader(System.in);
    public static BufferedReader bufferedReader = new BufferedReader(reader);

    public static void main (String[] args) throws IOException {

        System.out.print("Leer cadena: ");
        String s = leer();
        System.out.print("Leer caracter: ");
        char car = leerChar();
        System.out.print("Leer numero entero: ");
        int num1 = leerInt();
        System.out.print("Leer numero double: ");
        double num2 = leerDouble();

        reader.close();
        bufferedReader.close();


        System.out.println(" cadena: "+s);
        System.out.println(" caracter: "+car);
        System.out.println(" entero: "+num1);
        System.out.println(" numero real double: "+num2);

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\ejercicios\\prueba\\src\\EJ2_A1UD1\\Datos.txt"));
        bufferedWriter.write(" cadena: "+s);
        bufferedWriter.newLine();
        bufferedWriter.write(" caracter: "+car);
        bufferedWriter.newLine();
        bufferedWriter.write(" entero: "+num1);
        bufferedWriter.newLine();
        bufferedWriter.write(" numero real double: "+num2);
        bufferedWriter.newLine();
        bufferedWriter.close();
    }

    private static double leerDouble() {
        String texto=null;
        double numero = 0;
        try {
            texto = bufferedReader.readLine();
            numero = Double.parseDouble(texto);
        }catch (Exception e){
            texto = null;
            System.out.println("No es un entero.Intentalo de nuevo:");
        }
        return numero;
    }

    private static int leerInt() {
        String texto=null;
        int numero = 0;
        try {
            texto = bufferedReader.readLine();
            numero = Integer.parseInt(texto);
        }catch (Exception e){
            texto = null;
            System.out.println("No es un entero.Intentalo de nuevo:");
        }
        return numero;
    }

    private static char leerChar() throws IOException {
        char caracter;

        try {
            caracter = bufferedReader.readLine().charAt(0);
        }catch (Exception e) {
            caracter = ' ';
        }

        return caracter;
    }

    private static String leer() throws IOException {
        String texto = bufferedReader.readLine();

        return texto;
    }
}
