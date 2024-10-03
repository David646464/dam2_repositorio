package Tarea1.EJ2_A1UD1;

import java.io.*;

public class Teclado{
    public static InputStreamReader reader = new InputStreamReader(System.in);
    public static BufferedReader bufferedReader = new BufferedReader(reader);

    public static void main (String[] args) throws IOException {
        PrintStream out = new PrintStream(System.out);


        out.print("Leer cadena: ");
        String s = leer();
        out.print("Leer caracter: ");
        char car = leerChar();
        out.print("Leer numero entero: ");
        int num1 = leerInt();
        out.print("Leer numero double: ");
        double num2 = leerDouble();

        reader.close();
        bufferedReader.close();


        out.println(" cadena: "+s);
        out.println(" caracter: "+car);
        out.println(" entero: "+num1);
        out.println(" numero real double: "+num2);

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


