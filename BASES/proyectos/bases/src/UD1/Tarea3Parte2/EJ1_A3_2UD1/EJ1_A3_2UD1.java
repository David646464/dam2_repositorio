package UD1.Tarea3Parte2.EJ1_A3_2UD1;

import java.io.*;

public class EJ1_A3_2UD1 {
    public static void main(String[] args) throws IOException {
        contarLineasFichero(args);
    }



    private static void contarLineasFichero(String[] listaFicheros) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(listaFicheros[0],true));
        for (String ruta : listaFicheros){
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(ruta));
                long numeroLineas = bufferedReader.lines().count();
                bufferedWriter.write(ruta + ":tiene " + numeroLineas + " lineas");
                bufferedWriter.newLine();
            } catch (FileNotFoundException e) {
                System.out.println("No se encontro el fichero " + ruta);
                bufferedWriter.write(ruta + ":  ERROR al leer el fichero");
                bufferedWriter.newLine();

            }
        }
        bufferedWriter.close();
    }
}
