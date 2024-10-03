package Tarea1.EJ3_A1UD1;

import java.io.*;
import java.util.Scanner;

public class EJ3_A1UD1 {

    public static Scanner scanner = new Scanner("");
    public static void main (String[] args) throws IOException {
        abrirFichero();
        System.out.println("Introduce el número de enteros positivos para grabar en fichero:");
        int num=leerPositivo();
        for (int i=1;i<=num;i++){
            System.out.print("número "+i+":");
            grabarFichero(leerPositivo());
        }
        cerrarFichero();
        LeerFichero();
    }

    private static void LeerFichero() throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("src\\EJ3_A1UD1\\NumerosPositivos.txt"));
        while(scanner.hasNext()){
            scanner.useDelimiter(";");
            System.out.print(scanner.next() +" ");
        }
    }

    private static void cerrarFichero() {
        scanner.close();
    }



    private static void grabarFichero(int leerPositivo) throws IOException {
        PrintStream printStream = new PrintStream(new FileOutputStream(new File("src\\EJ3_A1UD1\\NumerosPositivos.txt"), true));

        printStream.print(leerPositivo + ";");

        printStream.close();
    }

    private static int leerPositivo() {
        Scanner sc = new Scanner(System.in);
        int numero =-1;
        while (numero < 0){
            try {
                numero = sc.nextInt();
                if (numero < 0){
                    System.out.println("NO es un numero entero positivo");
                }
            }catch (Exception e){
                System.out.println("NO es un numero entero positivo");
            }
        }

        return numero;
    }

    private static void abrirFichero() throws IOException {
        File archivo = new File("src\\EJ3_A1UD1\\NumerosPositivos.txt");
        try {
            scanner = new Scanner(archivo);
        }catch (Exception e){
            System.out.println("No hay archivo creado");
        }

    }

}
