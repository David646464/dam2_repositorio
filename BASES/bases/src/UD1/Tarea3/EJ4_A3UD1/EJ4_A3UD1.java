package UD1.Tarea3.EJ4_A3UD1;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EJ4_A3UD1 {
    public static void main(String[] args) {
        runCode();
    }

    private static void runCode() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe la ruta del archivo");
        String rutaArchivo = sc.nextLine();

        Map<Integer,Integer> mapa = leerMapa(rutaArchivo);

        for (Integer integer: mapa.keySet()){
                System.out.println(integer + " : " + mapa.get(integer));
        }
    }

    private static Map<Integer, Integer> leerMapa(String rutaArchivo) {
        Map<Integer,Integer> mapa = new HashMap<>();
        try {
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(rutaArchivo));
            Integer numero = dataInputStream.readInt();
            while (true){
                if (mapa.containsKey(numero)){
                    mapa.put(numero, mapa.get(numero) + 1 );
                }else{
                    mapa.put(numero,1);
                }
                numero = dataInputStream.readInt();
            }
        } catch (FileNotFoundException e) {
            System.out.println("No existe el archivo");
        } catch (Exception e) {
            System.out.println("Fin del programa");
            return mapa;
        }
        return mapa;
    }
}
