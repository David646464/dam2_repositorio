package Tarea3.EJ3_A3UD1;

import java.io.*;
import java.util.Scanner;

public class EJ3_A3UD1 {
    public static void main(String[] args) throws IOException {
        runCode();
    }

    private static void runCode() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe la ruta del primer archivo");
        String rutaArchivo1 = sc.nextLine();
        System.out.println("Escribe la ruta del segundo archivo");
        String rutaArchivo2 = sc.nextLine();
        System.out.println("Escribe la ruta del archivo final archivo");
        String rutaArchivoFinal = sc.nextLine();

        crearArchivo(rutaArchivo1,rutaArchivo2,rutaArchivoFinal);

    }

    private static void crearArchivo(String rutaArchivo1, String rutaArchivo2, String rutaArchivoFinal) throws IOException {
        DataInputStream dataInputStream1 = null;
        DataInputStream dataInputStream2 = null;
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(rutaArchivoFinal, true));
        int numero1 = 0;
        int numero2 = 0;
        boolean termino = true;
        try {
            dataInputStream1 = new DataInputStream(new FileInputStream(rutaArchivo1));
            numero1 = dataInputStream1.readInt();
            termino = false;
            dataInputStream2 = new DataInputStream(new FileInputStream(rutaArchivo2));
            numero2 = dataInputStream2.readInt();

            try  {
                while (true){
                    if (numero1 <= numero2){
                        dataOutputStream.writeInt(numero1);
                        termino = true;
                        numero1 = dataInputStream1.readInt();
                    }else{
                        dataOutputStream.writeInt(numero2);
                        termino = false;
                        numero2 = dataInputStream2.readInt();
                    }
                }

            } catch (IOException e) {

            }

        } catch (Exception e) {
            System.out.println("No existe algun archivo");
        }

        try {
            if (termino){
                while (true){
                    dataOutputStream.writeInt(numero2);
                    numero2 = dataInputStream2.readInt();
                }
            }else{
                while (true){
                    dataOutputStream.writeInt(numero1);
                    numero1 = dataInputStream1.readInt();
                }
            }
        } catch (Exception e) {
            System.out.println("Fin del programa");
        }
        dataOutputStream.close();
    }
}
