package UD1.Tarea3.EJ1_A3UD1;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class EJ1_A3UD1 {
    public static void main(String[] args) throws IOException {
        runCode();
    }

    private static void runCode() throws IOException {
        Random random = new Random();
        int [] arrayInt = new int[150];
        for (int i = 0; i < 150; i++) {
            arrayInt[i] = random.nextInt(60) + 20;

        }
        for (int a : arrayInt){
            System.out.println(a);
        }

        guardarInt(arrayInt,getNombreArchivo());
        leerInt(getNombreArchivo());

    }

    private static void leerInt(String nombreArchivo) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream(new File("src\\Tarea3\\EJ1_A3UD1\\" + nombreArchivo + ".dat")));

        try {
            while (true) {  // Loop infinito controlado por EOFException
                int numero = dataInputStream.readInt();  // Lee un entero
                System.out.println(numero);  // Muestra el entero
            }
        } catch (EOFException e) {
            // Fin del archivo alcanzado
            System.out.println("Fin del archivo.");
        }catch (Exception e){
            System.out.println("ERROR inesperado");
        } finally {
            dataInputStream.close();  // Cierra el flujo de entrada
        }
    }

    private static String getNombreArchivo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe el nombre del archivo");
        return sc.nextLine();
    }

    private static void guardarInt(int[] arrayInt, String nombreArchivo) throws IOException {
        File file = new File("src\\Tarea3\\EJ1_A3UD1\\" + nombreArchivo + ".dat");
        if (file.exists()){
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
            Scanner sc = new Scanner(System.in);
            System.out.println("El archivo existe quieres remplazarlo? S | N");
            if (sc.nextLine().equals("S")){
                for (int a : arrayInt){
                    dataOutputStream.writeInt(a);
                }
            }
            dataOutputStream.close();
        }else{
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
            for (int a : arrayInt){
                dataOutputStream.write(a);
            }
            dataOutputStream.close();
        }
    }
}
