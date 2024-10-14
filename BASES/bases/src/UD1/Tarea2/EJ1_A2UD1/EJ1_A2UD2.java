package UD1.Tarea2.EJ1_A2UD1;

import java.io.BufferedWriter;
import java.io.File;
import java.util.Scanner;


public class EJ1_A2UD2 {
    public static void main(String[] args) {
        runCode();

    }

    private static void runCode() {
        Scanner sc = new Scanner(System.in);
        File[] roots = File.listRoots();
        printMenu();
        String option = sc.nextLine();
        if (option.equalsIgnoreCase("P")) {
            System.out.println("---LISTANDO UNIDADES---");
            imprimirUnidades(roots);
        } else if (option.equalsIgnoreCase("D")) {
            salidaFichero(roots);
        } else {
            System.out.println("Opción no válida");
        }
    }

    private static void salidaFichero(File[] roots) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce el nombre del fichero");
        String nombreFichero = sc.nextLine();
        File fichero = new File("src\\Tarea2\\EJ1_A2UD2\\" + nombreFichero);


        try {
            fichero.createNewFile();
            System.out.println("Fichero creado correctamente");
            System.out.println("Listando unidades en fichero");
            BufferedWriter bw = new BufferedWriter(new java.io.FileWriter(fichero));
            for (File root : roots) {
                bw.write("Unidad " + root.getAbsolutePath() + ":");
                bw.newLine();
                bw.write("Espacio libre: " + root.getFreeSpace() + " (" + root.getFreeSpace() / (1024 * 1024 * 1024) + " GB)");
                bw.newLine();
                bw.write("Espacio Ocupado: "  + (root.getTotalSpace() - root.getFreeSpace()) + " (" + (root.getTotalSpace() - root.getFreeSpace()) / (1024 * 1024 * 1024) + " )");
                bw.newLine();
                bw.write("Espacio total: "  + root.getTotalSpace() + " (" + root.getTotalSpace() / (1024 * 1024 * 1024) + " GB)");
                bw.newLine();
            }
            bw.close();
        } catch (Exception e) {
            System.out.println("Error al crear el fichero");
        }
    }

    private static void imprimirUnidades(File[] roots) {
        for (File root : roots) {
            System.out.println("Unidad " + root.getAbsolutePath() + ":") ;
            System.out.println("Espacio libre: " + root.getFreeSpace() + " (" + root.getFreeSpace() / (1024 * 1024 * 1024) + " GB)");
            System.out.println("Espacio Ocupado: "  + (root.getTotalSpace() - root.getFreeSpace()) + " (" + (root.getTotalSpace() - root.getFreeSpace()) / (1024 * 1024 * 1024) + " )");
            System.out.println("Espacio total: "  + root.getTotalSpace() + " (" + root.getTotalSpace() / (1024 * 1024 * 1024) + " GB)");

        }
    }

    private static void printMenu() {
        System.out.println("Menu de opciones");
        System.out.println("----------------");
        System.out.println("[P] listado por pantalla");
        System.out.println("[D] listado por fichero");
        System.out.println("----------------");
        System.out.println("Elija opción---------------->");
        System.out.println("");
    }





    

}