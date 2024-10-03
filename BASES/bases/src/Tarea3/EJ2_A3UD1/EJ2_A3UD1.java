package Tarea3.EJ2_A3UD1;

import java.io.*;
import java.util.Scanner;

public class EJ2_A3UD1 {
    public static void main(String[] args) throws IOException {
        runCode();
    }

    private static void runCode() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe el nombre del archivo");
        String nombreArchivo = sc.nextLine();
        pedirNumero("src\\Tarea3\\EJ2_A3UD1\\" + nombreArchivo + ".dat");
        leerNumeros("src\\Tarea3\\EJ2_A3UD1\\" + nombreArchivo + ".dat");

    }

    private static void leerNumeros(String s) throws IOException {

        DataInputStream dataInputStream = new DataInputStream(new FileInputStream(s));

        try {
            while (true) {
                int numero = dataInputStream.readInt();
                System.out.println(numero);
            }
        } catch (EOFException e) {

            System.out.println("Fin del archivo.");
        }catch (Exception e){
            System.out.println("ERROR inesperado");
        } finally {
            dataInputStream.close();
        }
    }

    private static void pedirNumero(String s) {


        try {
            while (true){
                Scanner sc = new Scanner(System.in);
                int numero = sc.nextInt();
                if (compararNumero(numero,s)){
                guardarNumero(numero,s);
                }
            }
        }catch (Exception e){
            System.out.println("Fin del programa");
        }
    }

    private static void guardarNumero(int numero, String s) {
        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(s, true))) {
            dataOutputStream.writeInt(numero); // Escribir el número entero
            System.out.println("Número escrito en el archivo.");
        } catch (IOException e) {
            System.out.println("ERROR2");
        }
    }

    private static boolean compararNumero(int i, String s) {
        int ultimoNumero = -999999999;
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(s, "r")) {
            long fileLength = randomAccessFile.length();


            if (fileLength >= 4) {
                randomAccessFile.seek(fileLength - 4);
                ultimoNumero = randomAccessFile.readInt();

            }
        } catch (IOException e) {
            return true;
        }
        return  ultimoNumero <=i;
    }
}
